def bmicalculator():
    print("Welcome to BMI Calculator!")
    print("Please enter your weight in kilograms: ")
    weight = float(input())
    print("Please enter your height in meters: ")
    height = float(input())
    bmi = weight / (height * height)
    if bmi < 18.5:
        print("Your BMI is %d"%(bmi))
        print("You need to be fatter")
        exit()
    elif bmi >= 18.5 and bmi < 24:
        print("Your BMI is %d"%(bmi))
        print("You are perfect")
        exit()
    elif bmi >= 24:
        print("Your BMI is %d"%(bmi))
        print("You need to be thinner")
        exit()