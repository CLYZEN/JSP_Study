package ch08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistService service;

	public RegistController() {
		super();
	}

	// get, post 방식으로 오는 모든 request 데이터를 처리 가능
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"); // action파라미터 값 가져옴
		String view = "";

		// 1. 주소에 따라 어떤 페이지를 보여줄지 지정
		if (action == null) {
			// forward 실행시 페이지는 이동하지만 주소는 바뀌지 않음.
			// forward 실행시 requset, response 데이터를 다시 전달해줌.
			getServletContext().getRequestDispatcher("/rcontrol?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "info":
				view = info(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
		// 2. 페이지에 맞는 데이터를 view 페이지로 전달해주면 된다 (포워딩)
	}

	// 2-1. model 인 RegistService.java 에게 데이터 달라고 요청(메소드 실행)
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist prod = service.find(request.getParameter("id"));
		// setAttribute(key, value) 형태로 request 객체에 저장
		request.setAttribute("p", prod);
		return "registInfo.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Regist> plist = service.findAll();
		// setAttribute(key, value) 형태로 request 객체에 저장
		request.setAttribute("register", plist);
		return "registList.jsp";
	}

	// 수명주기당 한번 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // 서블릿
		service = new RegistService(); // 자원 최적화 (수명주기당 한번 생성)
	}
}
