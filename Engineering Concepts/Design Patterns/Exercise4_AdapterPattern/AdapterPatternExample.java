interface PaymentProcessor {
    void processPayment(double amount);
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Stripe processed payment of Rs. " + amount);
    }
}

class RazorpayGateway {
    public void payAmount(double amount) {
        System.out.println("Razorpay processed payment of Rs. " + amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway razorpayGateway;

    public RazorpayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    public void processPayment(double amount) {
        razorpayGateway.payAmount(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor stripePayment = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpayPayment = new RazorpayAdapter(new RazorpayGateway());

        stripePayment.processPayment(1500.0);
        razorpayPayment.processPayment(2500.0);
    }
}
