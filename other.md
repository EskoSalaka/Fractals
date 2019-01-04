# The fractals with other types of iteration iteration

These images are results of various other types of iteration processes. The one I currently have here is the 
"mandelpinski" type of iteration `Z -> f(Z)+C/f(Z)`

```scala 
def iterate_mdp(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s) + c/z
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }
```

# The images

Mandelpinski iteration for `f(Z) = Z^2` for x=[-0.5,0] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski1.png" width="50%" height="50%"> 

It seems to have some intricate convergence areas that are not clearly visible with our level of detail. Lets take a 
closer look at x=[-0.1,0] y=[-0.1,0.1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski2.png" width="50%" height="50%"> 

Lets xoom into the little mandelbrot at x=[-0.04,-0.029] y=[-0.057,-0.048]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski3.png" width="50%" height="50%"> 

The "center"  x=[-0.01,0] y=[-0.01,0.01]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski4.png" width="50%" height="50%"> 

---