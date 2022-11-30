function handleDeleteProductImage() {

	const productId = $('.productId').val();
	const btnDeleteImages = $('.btnDeleteImages');
	btnDeleteImages.click((e) => {
		e.preventDefault();
		const imagesSelected = [];
		$.each($("input[name='imageSelected']:checked"), function() {
			imagesSelected.push($(this).val());
		});
		const imagesSelectedStr = imagesSelected.join(',');

		$.ajax({
			url: "http://localhost:8080/shoplane-ft/system/products/images/delete/",
			type: 'GET',
			data: {
				imagesSelected: imagesSelectedStr,
				product_id: productId
			},
			success: function() {
				alert("Xóa ảnh thành công")
				window.location.reload();
			}
		});
	})
}
handleDeleteProductImage();

