        $("#cpf").keypress(function() {
            $(this).mask('000.000.000-00');
        });
        $("#cnpj").keypress(function() {
            $(this).mask('00.000.000/0000-00');
        });
        $("#cep").keypress(function() {
            $(this).mask('00000-000');
        });
        $("#altura").keypress(function() {
            $(this).mask('9,00', {reverse: true});
        });        
        $("#dinheiro").keypress(function() {
            $(this).mask('##0,00', {reverse: true});
        });        
        $("#telefone").keypress(function() {
            $(this).mask('(00) 00000-0000')
        });       
        $("#data").keypress(function() {
            $(this).mask('00/00/0000');
        });       
        $("#hora").keypress(function() {
           $(this).mask('00h 00m');
        });