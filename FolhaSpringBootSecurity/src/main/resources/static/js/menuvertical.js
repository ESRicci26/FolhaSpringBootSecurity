$('.parametros').click(function(){
$('.menuLateral ul .itensParametros').toggleClass('mostra');
});
$('.tabelas').click(function(){
$('.menuLateral ul .itensTabela').toggleClass('mostra');
});
$('.btnAbre').click(function(){
$('.menuLateral').toggleClass('mostra');
});
$('.btnFecha').click(function(){
$('.menuLateral').toggleClass('mostra');
});
$('.parametros').mouseover(function(){
$('.menuLateral ul .seta1').toggleClass('gira');
});
$('.parametros').mouseout(function(){
$('.menuLateral ul .seta1').toggleClass('gira');
});
$('.tabelas').mouseover(function(){
$('.menuLateral ul .seta2').toggleClass('gira');
});
$('.tabelas').mouseout(function(){
$('.menuLateral ul .seta2').toggleClass('gira');
});
const $menuLateral = $('.menuLateral');
$(document).mouseup(e => {
if(!$menuLateral.is(e.target)
&& $menuLateral.has(e.target).length === 0)
{
$menuLateral.removeClass('mostra');
}
});
