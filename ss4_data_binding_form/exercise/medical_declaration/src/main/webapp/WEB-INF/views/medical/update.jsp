<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/6/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Tờ Khai Y Tế </h1>
<h2>Đây là tài liệu quan trọng,thông tin anh/chị sẽ giúp cơ quan y tế liên lạc
    khi cần thiết để đề phòng phòng chống dịch bệnh</h2>
<h3 style="color: red">khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lí hình sự</h3>
<form:form action="submit" method="post" modelAttribute="medical">
    <table>
        <div>
            <div><label>Họ và tên</label></div>
            <div><form:input path="name"/></div>
        </div>

        <div>
            <div>
                <div><label>Năm sinh</label></div>
                <div>
                    <form:select path="year">
                        <form:options items="${year}"/>
                    </form:select>
                </div>
            </div>
            <div>
                <div><label>Giới</label></div>
                <div>
                    <form:select path="gender">
                        <form:options items="${gender}"/>
                    </form:select>
                </div>
            </div>
            <div>
                <div><label>Quốc gia</label></div>
                <div>
                    <form:select path="nationality">
                        <form:options items="${nationality}"/>
                    </form:select>
                </div>
            </div>
        </div>


        <div>
            <div><label>Số hộ chiếu hoặc CMND</label></div>
            <div>
                <form:input path="idCard"/>
            </div>
        </div>

        <div>
            <div>
                <form:checkboxes items="${vehicle}" path="vehicles"/>
            </div>
        </div>

        <div>
            <div><label>Số hiệu phương tiện</label></div>
            <div><form:input path="numberVehicle"/></div>
        </div>

        <div>
            <div><label>Số ghế</label></div>
            <div><form:input path="seat"/></div>
        </div>

        <div>
            <div><label>Ngày khởi hành</label></div>
            <div><form:input type="date" path="startDate"/></div>
        </div>

        <div>
            <div><label>Ngày kết thúc </label></div>
            <div><form:input type="date" path="endDate"/></div>
        </div>

        <div>
            <div><label>Trong vòng 14 ngày qua có đi đâu không?</label></div>
            <div><form:textarea path="place"/></div>
        </div>

        <div>
            <div><input type="submit" value="Update"></div>
            <div><input type="reset" value="Cancel"></div>
        </div>
    </table>
</form:form>
</body>
</html>
