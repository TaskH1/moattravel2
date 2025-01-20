const stripe = Stripe('pk_test_51QeTAS2NFn7L0f5IpbSiglql38PVOdZ5AaADdvXsMS2l2bbMKIlKMro3Z3DdQAe8QCedo4m24VgRbqi78QOaqeH800KWKOPtwu');
const paymentButton = document.querySelector("#paymentButton");

paymentButton.addEventListener("click", () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});