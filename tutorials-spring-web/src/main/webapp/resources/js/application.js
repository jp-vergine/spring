
var apps = function() {
	
	function init() {
		initDevice();
		initRestConsumer();
		initRestService();
		initScheduleTasks();
		initUpload();
	}
	
	function initDevice(){
		$.ajax({
			url : 'detect-device',
			type : "GET",

			complete : function(response) {
				$('#device-result').text(response.responseText);
			},

		});
		
	}
	
	function initRestConsumer(){
		$.ajax({
			url : 'restConsumer',
			type : "GET",

			complete : function(response) {

				var obj = jQuery.parseJSON(response.responseText);

				$('#restconsumer-name').text("Name: " + obj.name);
				$('#restconsumer-about').text("About: " + obj.about);
				$('#restconsumer-phone').text("Phone: " + obj.phone);
				$('#restconsumer-website').text("Website: " + obj.website);
			},

		});
	}
	
	function initRestService(){
		$('#restservice-submit').click(function(event) {

			$('#restservice-result').text("");

			var civility = $('#restservice-civility').val().trim();
			var name = $('#restservice-lastname').val().trim();

			if (name == '' || civility == '')
				return;

			var theurl = 'greeting?civility=' + civility + '&name=' + name;

			$.ajax({
				url : theurl,// 'greeting'
				type : "GET",
				dataType : "json",

				complete : function(response) {
					
					var obj = jQuery.parseJSON(response.responseText);

					$('#restservice-result').text(obj.id + " > "  + obj.content);
				},

			});
			event.preventDefault();
		});
	}
	
	function initScheduleTasks(){
		var socket = new SockJS('spring-websocket');
		var client = Stomp.over(socket);

		client.connect('user', 'password', function(frame) {

			client.subscribe("/scheduledTasks", function(message) {
				$('#scheduletask-result').html(message.body);
			});
		});
	}
	
	function initUpload(){
		$('#upload-submit').click(function(event) {

			var oMyForm = new FormData();
			oMyForm.append("file", file.files[0]);
			
			$.ajax({
				url : 'upload',
				data : oMyForm,
				dataType : 'text',
				processData : false,
				contentType : false,
				type : 'POST',
				
				success : function(data) {
					$('#upload-result').html(data);
				},
				error: function(jqXHR,error, errorThrown, data) {  
					$('#upload-result').html(new Date() +  " > Erreur: " + jqXHR.status + " > " + jqXHR.responseText);
				}
			});
			return false;
		});
	}
	
	
	
	return {
		init:function(){
			init();
		}
	};
}();


$(document).ready(function() {
	apps.init();
});




