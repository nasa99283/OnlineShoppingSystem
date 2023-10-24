package com.example.demo;

import com.example.demo.Admin.UserDto;
import com.example.demo.Model.Entity.Category;
import com.example.demo.Model.Entity.Product;
import com.example.demo.Model.Entity.User;
import com.example.demo.Model.Repository.UserRepository;
import com.example.demo.Services.CategoryService;
import com.example.demo.Services.CustomUserDetailsService;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	@Autowired
	UserRepository userRepository = null;
	@Autowired
	private UserService userService;



	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
@Autowired
	PasswordEncoder passwordEncoder;
@Autowired
	CustomUserDetailsService userDetailsService;

	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo() {

		return args -> {


			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter this Data to be able to signIn :");
			System.out.println("Enter your email (with @gmail.com):");
			String email = validateEmail(scanner.nextLine());

			System.out.println("Enter your password (with a special character, number, and capital letter):");
			String password = validatePassword(scanner.nextLine());

			System.out.println("Enter your role:");
			String role = scanner.nextLine();

			System.out.println("Enter your full name:");
			String fullname = scanner.nextLine();

			// Create UserDto
			UserDto userDto = new UserDto(email, password, role, fullname);

			// Save user
			User savedUser = userService.save(userDto);

			// Display the saved user details
			System.out.println("User saved successfully:");
			System.out.println("ID: " + savedUser.getId());
			System.out.println("Email: " + savedUser.getEmail());
			System.out.println("Role: " + savedUser.getRole());
			System.out.println("Full Name: " + savedUser.getFullname());
			System.out.println("Enter this Data to be able to signIn :");


			boolean loginSuccessful = false;

			while (!loginSuccessful) {
				System.out.println("Enter your email (with @gmail.com):");
				String username = validateEmail(scanner.nextLine());

				System.out.println("Enter your password (with a special character, number, and capital letter):");
				String yourPassword = validatePassword(scanner.nextLine());

				// Retrieve user details from the database
				UserDetails userDetails;
				try {
					userDetails = userDetailsService.loadUserByUsername(username);
				} catch (UsernameNotFoundException e) {
					System.err.println("User not found: " + username);
					continue;  // Repeat the loop if user is not found
				}

				// Check the entered password against the stored hashed password
				if (passwordEncoder.matches(yourPassword, userDetails.getPassword())) {
					System.out.println("Login successful!");

					// Check the role of the logged-in user
					if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
						System.out.println("Welcome, Admin!ROLE_ADMIN ");
					} else {
						System.out.println("Welcome, Customer/Normal User!");
					}

					loginSuccessful = true;
				} else {
					System.out.println("Login failed. Incorrect password. Try again.");
				}
			}
		};
	}

	private String validateEmail(String input) {
		if (!input.endsWith("@gmail.com")) {
			System.out.println("Email should end with @gmail.com. Please try again.");
			Scanner scanner = new Scanner(System.in);
			return validateEmail(scanner.nextLine());
		}
		return input;
	}

	private String validatePassword(String input) {
        // You can modify this regex pattern to match your specific requirements for special characters, numbers, and capital letters
        String passwordPattern = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d)(?=.*[A-Z]).*$";
        Pattern pattern = Pattern.compile(passwordPattern);

        Scanner scanner;
        if (!pattern.matcher(input).matches()) {
            System.out.println("Password should contain a special character, a number, and a capital letter. Please try again.");
            scanner = new Scanner(System.in);
            return validatePassword(scanner.nextLine());
        }

        return input;


        // Create categories
        Category womensCategory = categoryService.saveCategory(new Category("Womens"));
        Category mensCategory = categoryService.saveCategory(new Category("Mens"));
        Category childrensCategory = categoryService.saveCategory(new Category("Childrens"));

        // Display available categories
        System.out.println("Available Categories:");
        List<Category> allCategories = categoryService.getAllCategories();
        allCategories.forEach(category -> System.out.println(category.getId() + ". " + category.getName()));

        // Ask user to choose a category
        System.out.println("Enter the number of the category you want to choose:");
        long chosenCategoryId = scanner.nextLong();

        // Validate the chosen category
        Category chosenCategory = categoryService.getCategoryById(chosenCategoryId);
        if (chosenCategory == null) {
            System.out.println("Invalid category choice. Exiting...");
            return;
        }

        // Ask user to enter product details for the chosen category
        System.out.println("Enter product details for the chosen category: " + chosenCategory.getName());
        System.out.println("Enter product name:");
        scanner.nextLine();  // Consume the newline character
        String productName = scanner.nextLine();

        System.out.println("Enter product size (M: medium, S: small, L: large, XL: xlarge):");
        String productSize = scanner.next();

        System.out.println("Enter product color (Red, Pink, White, Black):");
        String productColor = scanner.next();

        // Create Product
        Product product = new Product(productName, productSize, productColor, chosenCategory);

        // Save product
        Product savedProduct = productService.saveProduct(product);

        // Display the saved product details
        System.out.println("Product saved successfully:");
        System.out.println("ID: " + savedProduct.getId());
        System.out.println("Name: " + savedProduct.getName());
        System.out.println("Size: " + savedProduct.getSize());
        System.out.println("Color: " + savedProduct.getColor());
        System.out.println("Category: " + savedProduct.getCategory().getName());
    };
}






























