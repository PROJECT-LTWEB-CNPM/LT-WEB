function handlePreviewImage() {
	// Preview image
	const pImage = document.querySelector('.product_img');

	$('.member-img').click(e => {
		const imgPreviewSrc = e.target.src;
		Object.assign(pImage.style, {
			backgroundImage: `url(${imgPreviewSrc})`,
		})
	})
}

function handleBtnQuantity() {
	const quantityInput = document.querySelector('.product_info-quantity-text');
	$('.btn-ins').click(() => {
		const { value } = quantityInput;
		quantityInput.value = +value + 1;
	})

	$('.btn-sub').click(() => {
		const { value } = quantityInput;
		if (+value > 1) {
			quantityInput.value = value - 1;
		}
	})
}

function handleAddToCart() {
	$('.btn__add-to-cart').click(() => {
		const data = { oId: '', quanty: '' };
		// Get quantity 
		data.quanty = $('.product_info-quantity-text').val();

		// Get checked radio
		const selected = $(".product_info-size-item input[type='radio']:checked");
		if (selected.length > 0) {
			data.oId = selected.val();
		}
		// Verify
		if (data.oId === '') {
			alert('Vui lòng chọn kích thước')
			return;
		}
		if (data.quanty === '') {
			alert('Vui lòng chọn số lượng')
			return;
		}

		// POST data using ajax
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/shoplane-ft/product-detail',
			data: data,
			success: function(result) {
				alert('Thêm sản phẩm thành công');
				handleChangeCartCount();
			},
			error: function(err) {
				alert('Thêm sản phẩm thất bại');
			}
		})
	})
}

function handlePayNow() {

}

function handleChangeCartCount() {
	window.location.reload();
	const cartCountString = $('#ordersCount').val() || '0';

	const cartCount = +cartCountString;
	$('.header_navbar-count').text(cartCount);
}

handlePreviewImage();
handleBtnQuantity();
handleAddToCart();