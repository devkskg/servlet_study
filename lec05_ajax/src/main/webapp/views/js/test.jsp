<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS방식</title>
</head>
<body>
	<input type="text" id="user_name">
	<input type="button" value="제출(1) get 방식" onclick="jsGetTest();">
	<input type="button" value="제출(2) post 방식" onclick="jsPostTest();">
	<div id="result_div">
		
	</div>
	<script>
		const jsGetTest = function(){
			console.log("연결 확인");
			// 1. XMLHttpRequest 객체 생성
			const xhr = new XMLHttpRequest();
			// 2. open() 메소드 호출
			// get 방식과 post 방식이 좀 다르다 우선 get 방식으로 해보자
			// 안 쓰면 알아서 비동기 방식으로 들어간다(true 라고 써도 비동기 방식)
			const userName = document.getElementById('user_name').value;
			// ?userName 여기서 유저네임 어디서 온 애임? +userName은 위의 const인데..
			// ?key = value 방식으로 쓴 것이다.
			// Get 파라미터로 뒷부분 가져오니 서블릿에 url 쓸때는 /jsAjaxGet 쓴다.
			// key는 서블릿의 getParameter의 매개변수로 쓴다.
			// 방식, 주소, 동기/비동기 를 매개변수로 써준다.
			xhr.open("get", "/jsAjaxGet?userusernamename="+userName);
			// 3. 서버 응답 처리 함수 생성
			xhr.onreadystatechange = function(){
				// 레디 스테이트(readyState 순서가 몇번째 까지 왔는가(응답 상태 확인))라는 정보가 같이 들어있다.
				if(xhr.readyState == 4 && xhr.status == 200){
					// state는 상태를 확인(Http 응답 상태 코드 확인).
					// 응답이 끝까지 도착했고 응답 코드도 200이면 잘 됐다.
					const result = xhr.responseText; // 글자로 왔으니 Text
					document.getElementById('result_div').innerHTML += result;
				}
			}
			// 4. 요청 보내기
			xhr.send();
		}
		
		// post 방식은 url에 데이터를 얹지 못하기 때문에 데이터 보내는 방식이 따로 정해져 있다.
		// send할때 매개변수로 key=value로 헤더에 추가하는 방식(여러개 보낼때는 &으로 연결)
		const jsPostTest = function(){
			// 1. 객체 생성
			const xhr = new XMLHttpRequest();
			// 2. open() 메소드 호출
			xhr.open("post", "/jsAjaxPost");
			// 3. 서버 응답 처리 함수 생성
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					document.getElementById('result_div').innerHTML += xhr.responseText;
				}
			}
			// 4. Content-Type을 설정
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			// 5. send() 함수 설정
			const userName = document.getElementById('user_name').value;
			xhr.send("userName="+userName);
		}
	</script>
</body>
</html>