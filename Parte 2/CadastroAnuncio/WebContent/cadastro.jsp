<!DOCTYPE html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
	<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>
<body>
	<form class="form-horizontal" method="POST" action= 'CadastroController' name="form" >
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
					<input id="Nome" name="Nome" placeholder="" class="form-control input-md" required="" type="text">
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
					Valor Investido 
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="investimento" name="investimento" placeholder="Apenas números"  class="form-control input-md" required=""  >
				</div>
				
				<label class="col-md-2 control-label" for="dtInicio">
					Início do investimento
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="dataInicio" name="dataInicio" placeholder="DD/MM/AAAA"  class="form-control input-md" required="" type="text" maxlength="10" OnKeyPress="MascaraData(form.dataInicio)" onBlur="minhaFuncao()">
				</div>
				
				<label class="col-md-2 control-label" for="dtFinal">
					Final do investimento
					<h11>*</h11>
				</label>
				<div class="col-md-2">
					<input id="dataFinal" name="dataFinal" placeholder="DD/MM/AAAA"  class="form-control input-md" required="" type="text" maxlength="10" OnKeyPress="MascaraData(form.dataFinal)" onBlur="minhaFuncao()">
				</div>
				
				
			</div>
			
						
			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-2 control-label" for="Cadastrar"></label>
				<div class="col-md-8">
					<button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
					<button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
				</div>
			</div>
			
		</fieldset>
	</form>
	<script>
		function MascaraCPF(cpf){
		    if(mascaraInteiro(cpf)==false){
		            event.returnValue = false;
		    }       
		    return formataCampo(cpf, '000.000.000-00', event);
		}
		
		function mascaraInteiro(){
		    if (event.keyCode < 48 || event.keyCode > 57){
		            event.returnValue = false;
		            return false;
		    }
		    return true;
		}
		
		function MascaraTelefone(tel){  
		    if(mascaraInteiro(tel)==false){
		            event.returnValue = false;
		    }       
		    return formataCampo(tel, '(00) 00000-0000', event);
		}
		function MascaraData(data){
	        if(mascaraInteiro(data)==false){
	                event.returnValue = false;
	        }       
	        return formataCampo(data, '00/00/0000', event);
		}
		function formataCampo(campo, Mascara, evento) { 
		    var boleanoMascara; 
		
		    var Digitato = evento.keyCode;
		    exp = /\-|\.|\/|\(|\)| /g
		    campoSoNumeros = campo.value.toString().replace( exp, "" ); 
		
		    var posicaoCampo = 0;    
		    var NovoValorCampo="";
		    var TamanhoMascara = campoSoNumeros.length;; 
		
		    if (Digitato != 8) { // backspace 
		            for(i=0; i<= TamanhoMascara; i++) { 
		                    boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
		                                                            || (Mascara.charAt(i) == "/")) 
		                    boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(") 
		                                                            || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " ")) 
		                    if (boleanoMascara) { 
		                            NovoValorCampo += Mascara.charAt(i); 
		                              TamanhoMascara++;
		                    }else { 
		                            NovoValorCampo += campoSoNumeros.charAt(posicaoCampo); 
		                            posicaoCampo++; 
		                      }              
		              }      
		            campo.value = NovoValorCampo;
		              return true; 
		    }else { 
		            return true; 
		    }
		}
		
		function calcIdade(ano_aniversario, mes_aniversario, dia_aniversario) {
		    	var d = new Date,
		        ano_atual = d.getFullYear(),
		        mes_atual = d.getMonth() + 1,
		        dia_atual = d.getDate(),
		
		        ano_aniversario = +ano_aniversario,
		        mes_aniversario = +mes_aniversario,
		        dia_aniversario = +dia_aniversario,
		
		        quantos_anos = ano_atual - ano_aniversario;
		
		    if (mes_atual < mes_aniversario || mes_atual == mes_aniversario && dia_atual < dia_aniversario) {
		        quantos_anos--;
		    }
		    	    
			
		    return quantos_anos < 0 ? 0 : quantos_anos;
		}
		
		function MascaraRG(rg){
		    if((rg)==false){
		            event.returnValue = false;
		    }       
		    return formataCampo(rg, '00.000.000-0', event);
		}
		
		function minhaFuncao(){
			var campo = document.getElementById('dtnasc').value;
			
			var arrDataExclusao = campo.split('/');
		
			var stringFormatada = arrDataExclusao[1] + '-' + arrDataExclusao[0] + '-' + arrDataExclusao[2];
			
			var dataFormatadaNascimento = new Date(stringFormatada);
			var year = dataFormatadaNascimento.getFullYear();
			var month = dataFormatadaNascimento.getMonth()+1;
			var day = dataFormatadaNascimento.getDate();
			var idade = calcIdade(year, month, day);
			
			if(idade < 18 ) {
				document.getElementById('Cadastrar').disabled=true;
				alert("Cadastro não pode ser efetuado ");
			}
			else{ 
				document.getElementById('Cadastrar').disabled=false;
			}
				
		}
	</script>
</body>
</html>