<!DOCTYPE html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
	<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>
<body>
	<form class="form-horizontal" method="POST" action= 'cadastro' name="form" >
		<fieldset>
			<div class="panel panel-primary">
			<div class="panel-heading">Cadastro de Anúncios</div>
			<div class="panel-body">
			<div class="form-group">
				<div class="col-md-11 control-label">
					<p class="help-block">
						<h11>*</h11>
						Campo Obrigatório 
					</p>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="Nome">
					Título do anúncio 
					<h11>*</h11>
				</label>
				<div class="col-md-8">
					<input id="nome" name="nome" placeholder="" class="form-control input-md" required="" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="NomeMae">
					Cliente 
					<h11>*</h11>
				</label>
				<div class="col-md-8">
					<input id="cliente" name="cliente" placeholder="" class="form-control input-md" required="" type="text">
				</div>
			</div>
			
			<div class="form-group">
			
				<label class="col-md-2 control-label" for="rg">
					Investimento por dia
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="investimento" name="investimento" placeholder="Apenas números"  class="form-control input-md" required onkeypress="return checkNumber(event)" onChange="numeroPositivo()" type="text"  > 
				</div>
				
				<label class="col-md-2 control-label" for="dtInicio">
					Início do investimento
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="dataInicio" name="dataInicio" class="form-control input-md" required type="date" onChange="verificaData()" >
				</div>
				
				<label class="col-md-2 control-label" for="dataFinal">
					Final do investimento (Não inclusa)
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="dataFinal" name="dataFinal" class="form-control input-md" required type="date" onChange="verificaData()" >
				</div>
				
				
			</div>
			
						
			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-2 control-label" for="Cadastrar"></label>
				<div class="col-md-8">
					<button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit" >Cadastrar</button>
					<button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
					<a class= "btn btn-primary"  href= "dashboard" role="button">Voltar</a>
				</div>
			</div>
			
		</fieldset>
	</form>
	
	<script>
		
		function verificaData() {
			var dti = document.getElementById("dataInicio");
			var dtf = document.getElementById("dataFinal");
			if (dti.value == "" || dtf.value == "") {
				document.getElementById("Cadastrar").disabled = true
			}
			else {
				if (Date.parse(dtf.value) > Date.parse(dti.value)) {
					document.getElementById("Cadastrar").disabled = false
				}
				else {
					if (Date.parse(dtf.value) > 0) {
						document.getElementById("Cadastrar").disabled = true
						alert("Data final do investimento precisa ser após a data inicial");
					}
				}
			}
		}
	
		function checkNumber(event) {
			return checkCharcode(event.charCode);
		}
		function checkCharcode(charCode) {
			return (charCode >= 48 && charCode <= 57) || (charCode == 44) || (charCode == 46);
		}
		
		function numeroPositivo(){
			var investimento = document.getElementById("investimento").value
			investimento = investimento.replace(",", ".");
			var num = parseFloat(investimento);
			if(num <=0){
				alert("Valor de investimento inválido");
				document.getElementById("Cadastrar").disabled = true
			}
			else{
				document.getElementById("Cadastrar").disabled = false
			}
		}
	</script>
</body>
</html>