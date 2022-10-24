function handleChangeCartCount() {
	const cartCount = $('#ordersCount').val() || 0;
	$('.header_navbar-count').text(cartCount);
	console.log(cartCount);
}

handleChangeCartCount();
