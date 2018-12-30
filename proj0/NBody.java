public class NBody{
	public static double readRadius(String file){
		In in = new In(file);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int num =in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[num];
		for(int i = 0; i < num; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
	        double yV = in.readDouble();
	        double m = in.readDouble();
	        String img =in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		In in = new In(filename);
		int num = in.readInt();
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(-radius, radius);
		String background = "images/starfield.jpg";
		StdDraw.picture(0, 0, background);
		for(Planet p: planets){
			p.draw();
		}

		StdDraw.enableDoubleBuffering();

		for(double time = 0;time < T; time += dt){

			double[] xForces = new double[num];
			double[] yForces = new double[num];
			
			for(int i = 0; i < num; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < num; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, background);
			for(Planet p: planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}		
	}
}