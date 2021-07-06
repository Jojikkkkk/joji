#include <algorithm>
#include <fstream>
#include <iostream>
#include <sstream>
#include <conio.h>
#include <string>
#include <cstring>
#include <unordered_map>
#include <ctime>
#include <vector>
using namespace std;
typedef unordered_map <string, int> MapType;
MapType words;
void intro(){
	cout << "\n\n\t\tTech Scholars Project (by Botong, Joji, Kamilah, Norbey, and Terrence)\n\n";
}
void search(MapType words){
    string s;
    cout << "Enter Keyword: ";
    cin >> s;
    transform(s.begin(),s.end(),s.begin(),::tolower);
    int ans=words[s];
    cout<<"\n>> '"<<s<<"' occurred "<<ans<<" time(s)\n";
}
void PowerUp() {
    ifstream myfile;
    myfile.open("F:\\Documents\\School\\Tech Scholars\\Project\\jobs.csv");

    int wordCount = 0;
    int lineNum = 0;

    string str;
    while (myfile >> str) {
        stringstream ss(str);
        while (ss) {
            string s;
            ss >> s;
            transform(s.begin(), s.end(), s.begin(),
                [](unsigned char c) { return tolower(c); });
            s.erase(
                remove_if(s.begin(), s.end(),
                    [](unsigned char c) { return isalpha(c) == 0; }),
                s.end());
            words.erase("and");
            words.erase("of");
            words.erase("to");
            words.erase("the");
            words.erase("a");
            words.erase("with");
            words.erase("or");
            words.erase("for");
            words.erase("as");
            words.erase("in");
            words.erase("work");
            words.erase("in");
            words.erase("ability");
            words.erase("skills");
            words.erase("on");
            words.erase("will");
            words.erase("be");
            words.erase("must");
            words.erase("an");
            words.erase("is");
            words.erase("team");
            words.erase("you");
            words.erase("other");
            words.erase("preferred");
            words.erase("required");
            words.erase("knowledge");
            words.erase("support");
            words.erase("at");
            words.erase("it");
            words.erase("from");
            words.erase("this");
            words.erase("by");
            words.erase("that");
            words.erase("at");
            words.erase("youll");
            words.erase("should");
            words.erase("if");
            words.erase("they");
            words.erase("us");
            words.erase("are");
            words.erase("all");
            words.erase("have");
            words.erase("our");

            if (!s.empty()) {
                ++wordCount;
                ++words[s];
            }
        }
        ++lineNum;
    }
}
bool display(){

    cout << "--START OF EXTRACTION--\n";
    vector<pair<string, int>> sort(3870, { "", 0 });

    partial_sort_copy(words.begin(), words.end(), sort.begin(), sort.end(),
        [](auto& a, auto& b) { return a.second > b.second; });

    for (auto& pair : sort) {
        cout << ">> '" << pair.first << "' occurred " << pair.second << " time(s)\n";
    }
    cout << "--END OF EXTRACTION--\n";
    ofstream file_out;
    file_out.open("F:\\Documents\\School\\Tech Scholars\\Project\\results.csv");

    file_out << "Words" << "," << "Occurences\n";
    for (auto& pair : sort) {
        file_out << pair.first << "," << pair.second << "\n";
    }
    return true;
}
void About() {
    cout << "Tech Scholars-Spring 1 copyright (c) 2021\n";
}
bool PowerDown() {
    cout << "safe shutting down\n";
    return true;
}

const char POWERUP{ '1' }, POWERDWN{ '3' };
const char ABOUT{ '2' }, QUIT{ 'Q' };
vector<char> CHOICES{ POWERUP, POWERDWN, ABOUT, QUIT }; 

bool process(char cmd) {
    bool result{ false };
    switch (toupper(cmd)) {
    case POWERUP:
        result = display();
        break;
    case ABOUT:
        search(words);
        result = true;
        break;
    case QUIT:
        result = PowerDown();
        break;
    }
    return result;
}
bool isValid(char c, const vector<char>& CHOICES)
{
    for (auto x : CHOICES)
        if (x == c) return true;
    return false;
}
char menu() {
    char choice;
    do {
        cout << "\n";
        cout << POWERUP << ". Extract Data\n";
        cout << ABOUT <<". Search Keyword\n";
        cout << POWERDWN << ". Exit Program\n";
        cout << "Enter Option: ";
        cin >> choice;
    } while (!isValid(choice, CHOICES));
    return choice;
}
int main() {
    PowerUp();
    intro();
    char cmd;
    do {
        cmd = menu();
        process(cmd);
    } while (toupper(cmd) != POWERDWN);
    cout << "\nExiting...\n";
}