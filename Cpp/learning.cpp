#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <limits>
#include <numeric>
#include <ctime>
#include <cmath>

// One of my first C++ programs to get an understanding of the syntax

std::vector<int> Range(int start, int end, int increment);
void printTree();
void guessNum();
void convertTemp();
std::string VectorToString(std::vector<std::string> vec, 
        char sep);

int main()
{
    std::vector<std::string> vCusts(3);
    vCusts[0] = "Bob";
    vCusts[1] = "Sue";
    vCusts[2] = "Tom";
    
    std::string sCusts = VectorToString(vCusts, ' ');
    std::cout << sCusts;
    convertTemp();
    printTree();
    guessNum();
    return 0;
}

//FUNCTIONS
std::string VectorToString(std::vector<std::string> vec, 
        char sep)
{
    std::string ans;
    for(auto y: vec)
        ans += y + sep;
    return ans;
}


std::vector<int> Range(int start, int end, int increment)
{
    std::vector<int> myVec(end / increment);
    for(int i = start, j = 0; j < myVec.size(); i += increment, j++)
        myVec[j] = i;
    
    return myVec;
}

void printTree()
{
    std::cout << "How tall is the tree : ";
    int height = 0;
    std::cin >> height;
    std::vector<int> myVec = Range(1, (height * 2), 2);
    // h = 1 v = [1]
    // h = 2 v = [1, 3]
    // h = 3 v = [1, 3, 5]
    // h = 4 v = [1, 3, 5, 7]
    int j = 0;
    //for(auto y: myVec)
    //    std::cout << y << "\n";
    for(int i = 0; i < height; i++)
    {
        j = i + 1;
        while(j - height != 0)
        {
            printf(" ");
            j++;
        }
        j = myVec[i];
        for(int x = 0; x < j; x++)
            std::cout << "#";
        
        std::cout << "\n";    
    }
    for(int i = 1; i < height; i++)
        std::cout << " ";
    std::cout << "#\n";
}

void guessNum()
{
    srand(time(NULL));
    int secretNum = std::rand() % 11;
    int guess = 0;
    while(true)
    {
        std::cout << "Guess Number : ";
        std::cin >> guess;
        if(guess > secretNum) std::cout << "Too high\n";
        if(guess < secretNum) std::cout << "Too low\n";
        if(guess == secretNum) break;
    }
    std::cout << "You guessed it!\n";
}

void convertTemp()
{
    std::string sInput;
    std::cout << "What do you want to convert? C/F : ";
    getline(std::cin, sInput);
    double dTemp = 0.0;
    
    if(sInput == "C")
    {  
        std::cout << "Please enter temperature value: ";
        std::cin >> dTemp;
        std::cout << dTemp << "C = " << (dTemp * (9.0 / 5) + 32) << "F\n";
    }
    else if(sInput == "F")
    {
        std::cout << "Please enter temperature value: ";
        std::cin >> dTemp;
        std::cout << dTemp <<"F = " << ((dTemp - 32) * (5.0 / 9)) << "C\n";
    }
    else
        std::cout << "Invalid input.\n";
}


//END FUNCTIONS

