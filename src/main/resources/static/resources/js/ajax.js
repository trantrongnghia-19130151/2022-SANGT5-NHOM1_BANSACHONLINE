
var book;
function displayBook(book) {
	var s = '';
	s += '<div class="row">'
	for (var i = 0; i < book.length; i++) {
		s += '<div class="product product__style--3 col-lg-4 col-md-4 col-sm-6 col-12">'
		s += '<div class="product__thumb">'
		s += '<a class="first__img" href="single-product.html"><img alt="product image"  src="..' + book[i].image + '"/></a>'
		s += ' <div class="hot__box">'
		s += '<span class="hot-label">BEST SALLER</span>'
		s += '</div>'
		s += '</div>'
		s += '<div class="product__content content--center">'
		s += '<h4><a href="single-product.html">' + book[i].name + '</a></h4>'
		s += '<ul class="prize d-flex">'
		s += '<li>' + book[i].price + '</li>'
		s += '<li class="old_prize">$35.00</li>'
		s += '</ul>'
		s += '<div class="action">'
		s += '<div class="actions_inner">'
		s += '<ul class="add_to_links">'
		s += '<li><a class="cart" href="cart/' + book[i].id + '"><i class="bi bi-shopping-bag4"></i></a></li>'
		s += '<li><a class="wishlist" href="wishlist.html"><i class="bi bi-shopping-cart-full"></i></a></li>'
		s += '<li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>'
		s += '<li><a data-toggle="modal" title="Quick View" class="quickview" id="' + book[i].id + '" href="#productmodal"><i class="bi bi-search"></i></a></li>'
		s += '</ul>'
		s += '</div>'
		s += '</div>'
		s += '<div class="product__hover--content">'
		s += '<ul class="rating d-flex">'
		s += '<li class="on"><i class="fa fa-star-o"></i></li>'
		s += '<li class="on"><i class="fa fa-star-o"></i></li>'
		s += '<li class="on"><i class="fa fa-star-o"></i></li>'
		s += '<li><i class="fa fa-star-o"></i></li>'
		s += '<li><i class="fa fa-star-o"></i></li>'
		s += '</ul>'
		s += '</div>'
		s += '</div>'
		s += '</div>'
	}
	$('#page1').html(s);
}

$(document).ready(function() {
	


	//auto complete search
	$('#search').keyup(function() {
		let name = $('#search').val();
		let len = name.length;
		
		$.ajax({
			method: 'GET',
			url: 'autoComplete',
			dataType: 'json',
			cache: 'no-cache',
			data: {
				name: name,
			}
		}).done(function(book) {
			console.log(book)
			var s = "";

			$('#result').on('click', function() {
				console.log(name.length)
				if (len == 0) {
					s += '';
					
				} else {
					s += '<div class="alert alert-info" >';
					for (var i = 0; i < book.length; i++) {
						s += '<a href="singleProduct/' + book[i].id + ' # " class="alert-link">' + book[i].name + '</a></br>'
					}
					s += '</div>';
				}
				$("#completeSearch").html(s);
			});


		});
	});


});


