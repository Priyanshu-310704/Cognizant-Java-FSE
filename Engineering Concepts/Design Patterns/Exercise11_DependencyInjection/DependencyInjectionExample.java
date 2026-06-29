interface CustomerRepository {
    String findCustomerById(int customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int customerId) {
        if (customerId == 101) {
            return "Customer{id=101, name='Amit'}";
        }
        return "Customer not found";
    }
}

class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerById(int customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println(service.getCustomerById(101));
        System.out.println(service.getCustomerById(202));
    }
}
