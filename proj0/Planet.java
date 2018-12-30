import java.lang.Math;

public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	public static double g = 6.67e-11;

	public Planet(double xP, double yP, double xV,
	              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;
		double r = Math.sqrt(dx*dx + dy*dy);
		return r;
	}

	public double calcForceExertedBy(Planet p){
		double r = calcDistance(p);
		double f = (g * mass * p.mass) / (r*r);
		return f;
	}

	public double calcForceExertedByX(Planet p){
		double dx, fx;
		if(xxPos >= p.xxPos){
			dx = xxPos - p.xxPos;
		}
		dx = p.xxPos - xxPos;
		fx = calcForceExertedBy(p) * dx / calcDistance(p);
		return fx;
	}

	public double calcForceExertedByY(Planet p){
		double dy, fy;
		if(yyPos >= p.yyPos){
			dy = yyPos - p.yyPos;
		}
		dy = p.yyPos - yyPos;
		fy = calcForceExertedBy(p) * dy / calcDistance(p);
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] ps){
		double fx = 0;
		for(Planet p: ps){
			if(this.equals(p)){
				continue;
			}
			fx += calcForceExertedByX(p);
		}
		return fx;
	}

	public double calcNetForceExertedByY(Planet[] ps){
		double fy = 0;
		for(Planet p: ps){
			if(this.equals(p)){
				continue;
			}
			fy += calcForceExertedByY(p);
		}
		return fy;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx/mass;
		double ay = fy/mass;
		xxVel += dt*ax;
		yyVel += dt*ay;
		xxPos += dt*xxVel;
		yyPos += dt*yyVel; 
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}
}