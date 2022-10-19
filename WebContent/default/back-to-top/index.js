

// Handle back to top
const backToTopRef = document.querySelector(".back-to-top");
const headerheight = 80;
document.addEventListener('scroll', () => {
	if (document.body.scrollTop > headerheight ||
		document.documentElement.scrollTop > headerheight) {
		backToTopRef.classList.add("visible");
	} else {
		backToTopRef.classList.remove("visible");
	}
})
backToTopRef.addEventListener('click', () => {
	window.scrollTo({ top: 0, behavior: 'smooth' });
})