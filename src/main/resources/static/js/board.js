let index = {
	init: function () {
		$("#btn-board-save").on("click", () => {
			this.save();
		});

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
	},

	save: function () {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type       : "POST",
			url        : "/api/board",
			data       : JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType   : "json"
		}).done(function (resp) {
			alert('글쓰기 완료');
			location.href="/";
		}).fail(function (error) {
			alert(JSON.stringify(error));
		});
	},

	deleteById: function () {
		let id = $("#id").text().trim();
		$.ajax({
			type       : "DELETE",
			url        : "/api/board/"+id,
			dataType   : "json"
		}).done(function (resp) {
			alert('삭제 완료');
			location.href="/";
		}).fail(function (error) {
			alert(JSON.stringify(error));
		});
	}
};

$(function(){
	index.init();
});