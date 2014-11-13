<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="civility-select" class="col-xs-3 control-label">Civilité:</label>
			<div class="col-xs-6">
				<select name="civility-select" id="restservice-civility" class="form-control" required>
					<option value=""></option>
					<option value="Monsieur">Monsieur</option>
					<option value="Madame">Madame</option>
					<option value="Mademoiselle">Mademoiselle</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="lastname-text" class="col-xs-3 control-label">Nom</label>
			<div class="col-xs-6">
				<input type="text" name="lastname-text" id="restservice-lastname" class="form-control" required />
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-offset-3 col-xs-6">
				<button type="submit" class="btn btn-primary" id="restservice-submit">Call rest service</button>
			</div>
		</div>
	</form>
	<pre id="restservice-result">Renseignez le formulaire...</pre>
	

</body>

</html>