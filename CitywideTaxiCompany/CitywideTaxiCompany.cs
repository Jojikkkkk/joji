// Joji Kashimura Project 4 11/28/2025

using System;
using static System.Console;

namespace CitywideTaxiCompany
{
    // Using the Taxi class definition from Project #3 
    public class Taxi
    {
        
        public string TaxiID { get; set; }
        public string DriverName { get; set; }
        public string CarMaker { get; set; }
        public string CarModel { get; set; }
        public string CarColor { get; set; }
        public string LicenseNumber { get; set; }
        
        // Instance variable: Number of passengers served by this specific taxi
        public int PassengersServed { get; set; }

        // --- Additional Requirements for Project #4 ---

        // Requirement: Static variable to accumulate passengers for the entire company
        public static int CompanyTotalPassengers = 0;

        // For random generation (shared by the class)
        private static Random _rand = new Random();

        // Default constructor from Project #3
        public Taxi()
        {
            TaxiID = "Unknown";
            DriverName = "Unknown";
            CarMaker = "Unknown";
            CarModel = "Unknown";
            CarColor = "Unknown";
            LicenseNumber = "Unknown";
            PassengersServed = 0;
        }

                public string ToCsvString()
        {
            return $"\"{TaxiID}\",\"{DriverName}\",\"{CarMaker}\",\"{CarModel}\",\"{CarColor}\",\"{LicenseNumber}\",\"{PassengersServed}\"";
        }

    
        public int DeterminePassengersAndServe()
        {
            // Randomly determine between 1 and 4 passengers
            int newPassengers = _rand.Next(1, 5);

            // Add to this taxi's passenger count
            this.PassengersServed += newPassengers;

            // Add to the company-wide (static) total
            CompanyTotalPassengers += newPassengers;

            return newPassengers;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            // Requirement: Declare six objects of Taxi with information included
            
            Taxi[] fleet = new Taxi[6];

            fleet[0] = new Taxi 
            { 
                TaxiID = "CTC0001", DriverName = "Ted", 
                CarMaker = "Toyota", CarModel = "Camry", CarColor = "red", 
                LicenseNumber = "T001" 
            };

            fleet[1] = new Taxi 
            { 
                TaxiID = "CTC0004", DriverName = "Ron", 
                CarMaker = "Ford", CarModel = "Escape", CarColor = "black", 
                LicenseNumber = "T002" 
            };

            fleet[2] = new Taxi 
            { 
                TaxiID = "CTC0007", DriverName = "Alice", 
                CarMaker = "Honda", CarModel = "Civic", CarColor = "silver", 
                LicenseNumber = "T003" 
            };

            fleet[3] = new Taxi 
            { 
                TaxiID = "CTC0012", DriverName = "Bob", 
                CarMaker = "Toyota", CarModel = "Prius", CarColor = "white", 
                LicenseNumber = "T004" 
            };

            fleet[4] = new Taxi 
            { 
                TaxiID = "CTC0015", DriverName = "Carol", 
                CarMaker = "Chevy", CarModel = "Malibu", CarColor = "blue", 
                LicenseNumber = "T005" 
            };

            fleet[5] = new Taxi 
            { 
                TaxiID = "CTC0020", DriverName = "Dave", 
                CarMaker = "Ford", CarModel = "Crown Vic", CarColor = "yellow", 
                LicenseNumber = "T006" 
            };

            WriteLine("Welcome to CTC.");

            Random dispatcherRand = new Random();
            string userResponse = "";

            // Main loop
            while (true)
            {
                WriteLine("Do you need a taxi? (Y/N)");
                
                userResponse = ReadLine()?.ToUpper() ?? "";

                if (userResponse == "N")
                {
                    break;
                }
                else if (userResponse == "Y")
                {
                    // Requirement: A taxi is randomly selected (0 to 5)
                    int taxiIndex = dispatcherRand.Next(0, 6);
                    Taxi selectedTaxi = fleet[taxiIndex];

                    // Requirement: Determine and retrieve passenger count using the function in the object
                    int currentPassengers = selectedTaxi.DeterminePassengersAndServe();

                    
                    WriteLine($"Taxi {selectedTaxi.TaxiID} a {selectedTaxi.CarColor} {selectedTaxi.CarMaker} {selectedTaxi.CarModel} driven by {selectedTaxi.DriverName} will pick you up in a few minutes. (Taxi {selectedTaxi.TaxiID} determined that there were {currentPassengers} passengers)");
                }
                else
                {
                    WriteLine("Invalid input. Please enter Y or N.");
                }
                
                WriteLine(); // New line
            }

            WriteLine();
            WriteLine("-----------------------------------");
            
            // Requirement: Display total number of passengers served by the entire company (static variable)
            WriteLine($"CTC served a total of {Taxi.CompanyTotalPassengers} passengers today.");
            
            // Requirement: Display total number of passengers served by each taxi
            foreach (Taxi t in fleet)
            {
                WriteLine($"{t.DriverName} served {t.PassengersServed} passengers.");
            }
            
            // Wait for input before closing
            ReadLine();
        }
    }
}