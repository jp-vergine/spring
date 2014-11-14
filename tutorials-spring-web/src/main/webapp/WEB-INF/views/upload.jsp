
<!DOCTYPE html>
<html>

<head>

</head>


<body>
	<form class="form-horizontal" role="form" id="form2" method="post" action="/upload" enctype="multipart/form-data">
		<div class="form-group">
			<div class="col-xs-6">
				<input name="file" id="file" type="file" />
			</div>
		</div>
		<button type="submit" class="btn btn-primary btn-block"  id="upload-submit">Import file</button>
	</form>
	<div class="row">
		<div class="text-center" id="upload-result"></div>
	</div>

</body>

</html>
