const proSelects = $('#province');
const disSelects = $('#district');
const wardSelects = $('#ward');
const orderBtn = $('.btn__order');

function createOptionList(list) {
	return list.map(item => createOption(item.code, item.name)).join("");
}

function createOption(value, text) {
	return `<option value="${value}">${text}</option>`;
}


const app = {
	baseUrl: "https://provinces.open-api.vn/api",
	handleGetAllPros() {
		$.ajax({
			url: `${this.baseUrl}/p`,
			type: 'GET',
			dataType: 'json', // added data type
			success: function(res) {
				let html = ""
				if (res) {
					html = createOptionList(res);
				}
				proSelects.append(html);
			},
		})
	},
	handleGetDisByProCode(proCode) {
		$.ajax({
			url: `${this.baseUrl}/p/${proCode}?depth=2`,
			type: "GET",
			success: function(res) {
				let html = "";
				if (res.districts) {
					html = `<option value="-1">Vui lòng chọn quận (huyện)...</option>`
						.concat(createOptionList(res.districts));
				}
				disSelects.empty();
				disSelects.append(html);
				wardSelects.empty();
				wardSelects.append(`<option value="-1">Vui lòng chọn phường (xã)...</option>`);
			}
		})
	},
	handlegetWardByDisCode(disCode) {
		$.ajax({
			url: `${this.baseUrl}/d/${disCode}?depth=2`,
			type: "GET",
			success: function(res) {
				let html = "";
				if (res.wards) {
					html = `<option value="-1">Vui lòng chọn phường (xã)...</option>`
						.concat(createOptionList(res.wards));
				}
				wardSelects.empty();
				wardSelects.append(html);
			}
		})

	},
	handleProSelectChange() {
		proSelects.change(() => {
			const selectedVal = $("#province option:selected").val();
			this.handleGetDisByProCode(selectedVal);
		});
	},
	handleDisSelectChange() {
		disSelects.change(() => {
			const selectedVal = $("#district option:selected").val();
			this.handlegetWardByDisCode(selectedVal);
		});
	},

	handleSubmitOrder() {
		orderBtn.click(() => {
			// get data
			const totalPrice = $('input[name="totalPrice"]').val().trim();
			const fullname = $('input[name="fullname"]').val().trim();
			const phonenumber = $('input[name="phonenumber"]').val().trim();
			const extraAddress = $('input[name="address"]').val().trim();
			const province = $("#province option:selected").text().trim();
			const district = $("#district option:selected").text().trim();
			const ward = $("#ward option:selected").text().trim();
			const address = `${extraAddress}, ${ward}, ${district}, ${province}`;

			// Validate
			if (fullname === "") {
				alert("Họ tên không được để trống");
				return;
			}
			if (phonenumber === "") {
				alert("Số điện thoại không được để trống");
				return;
			}
			if ($("#province option:selected").val() === '-1') {
				alert("Vui lòng chọn thành phố");
				return;
			}
			if ($("#district option:selected").val() === '-1') {
				alert("Vui lòng chọn huyện");
				return;
			}
			if ($("#ward option:selected").val() === '-1') {
				alert("Vui lòng chọn xã");
				return;
			}
			// Create data
			const data = {
				fullname,
				phonenumber,
				address,
				totalPrice
			}
			console.log(data)
			// Post data
			request = $.ajax({
				url: "http://localhost:8080/shoplane-ft/checkout",
				type: "POST",
				data: data,
				success: function(res) {
					if (res === 'success') {
						window.location.reload()
					}
				}
			});

		})
	},
	run() {
		this.handleGetAllPros();
		this.handleProSelectChange();
		this.handleDisSelectChange();

		// Handle submit
		this.handleSubmitOrder();
	}
}


app.run();