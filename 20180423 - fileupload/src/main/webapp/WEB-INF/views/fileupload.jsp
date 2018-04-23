<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>spring mvc fileupload</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<!-- jquery로 파일 첨부 추가 -->
	<script type="text/javascript">
		$(document).ready(function(){
			//add more file components if Add is clickd
			$('#addFile').click(function(){
				var fileIndex = $('#fileview tr').children().length;
				$('#fileview').append(
					'<tr><td>' + 
					'	<input type="file" name="files['+ fileIndex +']" />' +
					'</td></tr>');
			});
		});
	</script>
</head>
<body>
	<h3>Spring WEB MVC MultiFile Upload</h3>
	<form:form method="post" action="save.html" modelAttibute="uploadForm" enctype="multipart/form-data">
		<!-- 아래 경로는 적절히 수정하자. 이경로에 파일이 업로드 된다. -->
		Upload	Directory	:	<input type="text" name="upDir" value="C:\Intel" /><br><br>
		<input id="addFile" type="button" value="File Add" />
		<table id="fileview">
			<tr>
				<td><input type="file" name="files[0]" /></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="Upload"/>
	</form:form>
</body>
</html>
