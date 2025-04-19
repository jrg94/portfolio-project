#include <stdio.h>

int main()
{
    int num1, num2, result;

    // Input two numbers
    printf("Enter first number: ");
    scanf("%d", &num1);

    printf("Enter second number: ");
    scanf("%d", &num2);

    // Multiply the numbers
    result = num1 * num2;

    // Output the result
    printf("Multiplication of %d and %d is %d\n", num1, num2, result);

    return 0;
}
