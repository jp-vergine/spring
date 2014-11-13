
<!DOCTYPE html>
<html>

<head>

</head>


<body>
	<!--  Form 2 -->
	<i>Uploading simple File With Ajax</i>
	<br />
	<form class="form-horizontal" role="form" id="form2" method="post" action="/upload" enctype="multipart/form-data">
		<div class="form-group">
			<label for="file" class="col-xs-3 control-label">Fichier 1:</label>
			<div class="col-xs-6">
				<input name="file" id="file" type="file" />
			</div>
		</div>
		<br />
	</form>
	<div class="form-group">
		<div class="col-xs-offset-3 col-xs-6">
			<button type="submit" class="btn btn-primary"  id="upload-submit">Import file</button>
		</div>
	</div>
	<div id="upload-result"></div>

</body>

</html>
