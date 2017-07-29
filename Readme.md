## FitMeter ##
FitMeter is simple program which I created for tracking walked steps and burned calories with my Garmin Vivofit wearable.

### FEATURES ###
+ Recording daily activity - steps, burned calories and personal notes

## Installation ##
Simply copy or clone the FitMeter repository into desired folder and run it Eclipse or command line like java App.class

## Development
### CURRENTLY WORKING ###
+ Write tests to check the shift
+ Complete shift from .txt to .csv data storage

### TODO ###
+ Write more comments 
+ Write more unit tests
+ Implement check for correct user inputs (dates, etc.)
+ Implement mini gif/video of app usage into the Readme.md
+ Implement check for order by date after every new record
+ Implement into menu option to select certain date range and show statistics for selected period
+ Support inserting records over script command line
+ Create option to add personal note/description to each day
+ Gradually build GUI with Spring and stand-alone "double-click" app

### DONE ###
+ Improve Readme.md
+ App renamed to FitMeter
+ Project turned to Maven project
+ Refactor code - Created Menu class
+ Implemented OpenCSV for handling .csv 