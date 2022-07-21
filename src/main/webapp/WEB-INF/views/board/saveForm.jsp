<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
        </div>
        <div class="form-group">
            <label for="content">content:</label>
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>
        <button id="btn-board-save" class="btn btn-primary">저장</button>
    </form>
</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height : 300
    });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

</body>
</html>



