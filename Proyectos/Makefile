pdf:
	pdflatex tp1.tex

ignorando-errores:
	pdflatex -interaction=nonstopmode tp1.tex

bibliografia:
	pdflatex tp1.tex
	bibtex tp1.aux
	pdflatex tp1.tex
	pdflatex tp1.tex

clean:
	- rm -f *.log *.soc *.toc *.aux *.out  main.idx *.bbl *.bbg *.dvi *.blg *.lof *.nav *.snm *~

