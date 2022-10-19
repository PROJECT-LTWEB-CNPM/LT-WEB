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
	console.log(quantityInput.value);
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

handlePreviewImage();
handleBtnQuantity();