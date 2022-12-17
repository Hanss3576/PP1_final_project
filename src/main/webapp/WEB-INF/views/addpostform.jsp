<%--
  Created by IntelliJ IDEA.
  User: hanss
  Date: 2022/12/04
  Time: 3:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://kit.fontawesome.com/ebba58ba2d.js" crossorigin="anonymous"></script>
    <title>New Post</title>
</head>
<body>
    <h1>New Post</h1>
    <form action="addok" method="post">
        <table>
            <tr>
                <td>제목</td>
                <td><input type="text" name="title" size="20"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="writer" size="20"></td>
            </tr>
            <tr>
                <td>찬양팀</td>
                <td>
<%--                    <input type = "radio" name = "worshipTeam" value = "프레이즈">프레이즈--%>
<%--                    <input type = "radio" name = "worshipTeam" value = "끝시간">끝시간--%>
<%--                    <input type = "radio" name = "worshipTeam" value = "강물">강물--%>
                    <select name="worshipTeam">
                        <option value="프레이즈">프레이즈</option>
                        <option value="끝시간">끝시간</option>
                        <option value="강물">강물</option>
                        <option value="기타/신앙공동체">기타/신앙공동체</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>참고 내용</td>
                <td><textarea name="content" cols="50" rows="5"></textarea></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="작성">
                    <button type="button"  onclick="location.href='list'">
                        <i class="fas fa-list"></i>
                        돌아가기
                    </button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
