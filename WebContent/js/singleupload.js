$(document).ready(function() {
	$("#upForm1").ajaxForm({
		success: function(data, status) { //업로드에 성공하면 수행
			$("#upResult").html(data); //응답받은 결과를 표시
		}
	});
});