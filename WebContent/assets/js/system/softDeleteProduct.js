function handleDeleteProductImage() {

	const btnDeleteProducts = $('.btnDeleteProducts');
	btnDeleteProducts.click((e) => {
		e.preventDefault();
		const productsSelected = [];
		$.each($("input[name='productSelected']:checked"), function() {
			productsSelected.push($(this).val());
		});
		const productsSelectedStr = productsSelected.join(',');

		$.ajax({
			url: "http://localhost:8080/shoplane-ft/system/products/delete/",
			type: 'GET',
			data: {
				productsSelected: productsSelectedStr
			},
			success: function() {
				alert("Xóa ảnh thành công")
				window.location.reload();
			}
		});
	})
}
handleDeleteProductImage();

