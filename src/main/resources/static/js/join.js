$(document).ready(function () {    
    $("#joinButton").click(function(){

        // json 형식으로 데이터 set
        var params = {

                  name         : $("#inputName").val()
                , user_id      : $("#inputId").val()
                , user_pw      : $("#inputPw").val()
                , birth        : $("#inputBirth").val()
                , email        : $("#inputMail").val()
                , phone_number : $("#inputPhoneNum").val()
        }
            
        // ajax 통신
        $.ajax({
            type : "POST",            // HTTP method type(GET, POST) 형식이다.
            url : "http://192.168.0.29:8080/users/signUp",       // 컨트롤러에서 대기중인 URL 주소이다.
            data: JSON.stringify(params),
            dataType : "JSON", //datatype "jsonp" get방식일때만 사용 가능 / 보낼 때 CORS에 대한 처리가 백단에서 되어있어야함
            async    : true,
            contentType : "application/json",
            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                // 응답코드 > 0000
                //alert(res.code);
                //location.href = "index.html";
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("통신 실패.")
            }
        });
    });
        
});
