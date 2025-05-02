# ImageFrame – Java projects

I created this project in Eclipse under the name `ImageFrame`, within the `Portofolio` package. It contains several classes that represent a part of the projects I have completed using the Java programming language. The purpose of this repository is to showcase my knowledge of Java through practical examples, clearly structured in code. Each class illustrates different concepts learned during my studies or applied in individual projects – ranging from basic elements to more advanced functionalities.

`ColoredCircleFrame` is a Java application of type JFrame that draws a colored circle, transitioning from dark red to light red, starting from black.

`Frame` simulates a student registration form for an online course. The user can input information such as first name, last name, year of study, faculty, type of funding (budget/fee), and desired course. The year of study, faculty, and course are presented as dropdown lists (JComboBox), while the funding option is a checkbox. After completing the form, the information is displayed in a JTextArea when the registration button is pressed, and the data is saved in a text file (PbFrame).

`Game` is a graphical Java application that contains a button labeled `Start` and a Canvas component. When the button is pressed, its label changes to `Stop` and a thread is started that animates a circle inside the Canvas. The circle starts from the top-left corner and moves diagonally, changing its trajectory when it hits the edges of the window. The thread stops when the button is pressed again.

`ImageFrame` is an application that allows the user to modify the color of a 100x100 square using three sliders corresponding to the RGB components (Red, Green, Blue). The color is applied to the square in real-time within a graphical component (Canvas).

`ImageFrame2` is an interactive Java application that measures the user's reaction time. The application randomly generates 10 circles, each in either red or black. The user needs to click the button corresponding to the displayed color (RED or BLACK). At the end, the app shows the number of correct responses and the average reaction time, calculated using the System.currentTimeMillis() method.

`ImageFrame3` is a graphical Java application in which the user can input the values for the R, G, and B components of a color in a set of TextFields. After pressing a button, the application checks if the entered values are correct (numeric and between 0 and 255). If the values are valid, a Label will display the resulting color. Otherwise, the Label will show an error message in red, informing the user that the values are incorrect (`Incorrect values! Values must be between 0-255.`), using exceptions for validation.
