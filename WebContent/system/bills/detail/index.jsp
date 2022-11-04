<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="utils.Helper"%>

<%
request.setCharacterEncoding("utf-8");
String baseUrl = request.getContextPath() + "/system/bills/form";
%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../../head.jsp" />
<title>Quản lý đơn hàng - Shoplane</title>
<link rel="stylesheet" href="../index.css" type="text/css"/>
<style>
h3{
   color:#333333;
}
.information-section{
  padding: 0 30%;
  margin-top: 50px;
}

.form-rows{
  display: flex;
  padding: 10px;
  width: 100%;
}


.col-3s{
  width: 30%;
}


.col-7s{
  width: 70%;
  margin-left: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.col-7s input{
  width: 100%;
  border-radius: 10px;
  border: solid 1px #333333;
  padding: 5px;
}

.col-7s .radio{
	width: 15%;
}



.button-items{
  background-color: #ffffff;
  border: 1px solid #333333;
  border-radius: 8px;
  color:#333333;
  padding: 5px 10px;
}

.button-items:hover{
  border: none;
  color: #ffffff;
  background: #333333;
}


@media(max-width: 1500px){
  .information-section{
    padding: 0 15%;
  }
}

@media(max-width: 1000px){
  .form-rows{
    flex-direction: column;
  }

  .col-3s, .col-7s{
    width: 100%;
  }

  .wrap-info{
    width: 100%;
  }

  .col-7s{
    margin-left: 0;
  }
}
</style>

</head>
<body>
	<div id="app">
		<div id="sidebar">
			<jsp:include page="../../partials/sidebar/index.jsp" />
		</div>
		<div id="content">
			<div id="header">
				<jsp:include page="../../partials/header/index.jsp" />
			</div>
			
			 <main class="information-section">
      	
          <form  action="./detail" method="post">
          
          	<div class="form-rows">
              <div class="col-3s">
               
              </div>
              <div class="col-7s">
                 	<h3>Cập nhật hoá đơn </h3>
              </div>
            </div>

            <div class="form-rows">
              <div class="col-3s">
                <label for="">Mã đơn hàng </label>
              </div>
              <div class="col-7s">
                <input  type="text" name="billId" value="${bill.billId}" readonly>
              </div>
            </div>

            <div class="form-rows">
              <div class="col-3s">
                <label for="">Ngày tạo </label>
              </div>
              <div class="col-7s">
                <input class="" type="text" name="date" value="${Helper.dateWithoutTime(bill.date)}" readonly>
              </div>

            </div>

            <div class="form-rows">
              <div class="col-3s">
                <label for="">Mã khách hàng </label>
              </div>
              <div class="col-7s">
                <input class="" type="text" name="customerId" value="${bill.user.userId}">
              </div>
            </div>

            <div class="form-rows">
              <div class="col-3s">
              </div>
              <div class="col-7s ">
             	 <c:choose>
    					<c:when test="${b.statusBill==1}">
        					<input class="radio" type="radio" id="done" name="status" value="1" checked="checked">
  							<label for="done">Đã thanh toán </label>
               				<input class="radio" type="radio" id="notYet" name="status" value="0">
 							<label  for="notYet">Chưa thanh toán </label>
        				</c:when>    
    					<c:otherwise>
        					<input class="radio" type="radio" id="done" name="status" value="1">
  							<label for="done">Đã thanh toán </label>
               				<input class="radio" type="radio" id="notYet" name="status" value="0" checked="checked">
 							<label  for="notYet">Chưa thanh toán </label>
        				</c:otherwise>
					</c:choose>
              </div>
            </div>

            <div class="form-rows">
              <div class="col-3s">
                <label for="">Tổng thanh toán </label>
              </div>
              <div class="col-7s">
                <input type="text" name="totalPrice" value="${bill.totalPrice}">
              </div>
            </div>
            
         	<div class="form-rows">
            <div class="col-3s">
            </div>
            <div class="col-7s">
              <button class="btn-confirm-change button-items" type="submit" name="button">Lưu thay đổi</button>
            </div>
          </div>

          </form>
          

        </main>
			
			
		</div>
	</div>
	<!-- Jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>