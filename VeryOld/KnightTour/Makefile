CC = gcc
INCLUDE = .
CFLAGS = -g -Wall -ansi
run: KnightTour.exe
	@./KnightTour.exe $(ARG1) $(ARG2)				# e.g. make ARG1=0 ARG2=0
KnightTour.exe:
	$(CC) $(CFLAGS) -o KnightTour.exe KnightTour.c
clean:
	rm ./*.exe
