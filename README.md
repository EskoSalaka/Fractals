#Fractals

<img src="Images/exponential_feedback_m2.png" height="500" width="500"> 

Fractals is a simple small project just to explore some interesting fractal maps and iterations methods
not commonly seen around the internet. The code itself is not very well optimized and the colour mappings
are not terribly pretty but it's good enough for an on-the-surface look into some interesting stuff.

The complex-valued functions explored are typically something related to the exponential function e^z or 
certain interesting rational functions like z^2*(1-z)/(1-z^2). Aside from the normal simple iteration

`Zn+1 --> f(Zn)` where `Z0=c`

and Mandelbrot-style iteration

`Zn+1 --> f(Zn) + c`

we will also explore some other interesting types such as iteration with feedback

`Zn+2 --> f(Zn+1) + Zn` where `Z0=0`

and iteration alternating between multiple functions

`Zn+1 --> f1(Zn) when n % 2 == 0 else Zn+1 --> f2(Zn)`

###Some examples

The normal mandelbrot set `Z --> Z + c`

<img src="Images\mandelbrot.png" height="500" width="500"> 


Exponential function `Z --> exp(Z) + C` with mandelbrot-style iteration
<img src="Images\exponential_m3.png" height="5000" width="500"> 

Mandelbrot-style iteration alternating between `Z --> Z^2` and `Z --> i*Z^2`
<img src="Images\rational_alt1.png" height="5000" width="500"> 