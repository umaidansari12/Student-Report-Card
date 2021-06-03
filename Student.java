import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Student{
    private String Name;
    private String PhoneNumber;
    private String[] SubjectName;
    private double Marks[];
    private double TotalMarks;
    private double Total;
    private double Percentage;
    private char Grade;
    Student(){

    }
    Student(String name,String phoneNumber,String [] subjectName,double marks[]){
        Name = name;
        PhoneNumber = phoneNumber;
        SubjectName = subjectName;
        Marks = marks;
        TotalMarks = marksCalculator();
        Total=(100.0f)*Marks.length;
        Percentage = (TotalMarks/Total)*100.0;
        Grade = gradeCalculator();
    }
    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name = name;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
    public String [] getSubjectName(){
        return SubjectName;
    }
    public void setSubjectName(String[] subjectName){
        SubjectName = subjectName;
    }
    public double[] getMarks(){
        return Marks;
    }
    public void setMarks(double[] marks){
        Marks = marks;
    }
    public double getTotalMarks(){
        return TotalMarks;
    }
    public double getPercentage(){
        return Percentage;
    }
    public char getGrade(){
        return Grade;
    }
    public double marksCalculator(){
        double totalMarks = 0.0f;
        for(int j=0;j<Marks.length;j++){
            totalMarks+=Marks[j];
        }
        return totalMarks;
    }
    public char gradeCalculator()
    {
        char grade='D';
        if(Percentage>=90.0){
            grade='A';
        }
        else if(Percentage<90.0 && Percentage>=70.0){
            grade='B'; 
        }
        else if(Percentage<70.0 && Percentage>=60.0){
            grade='C';
        }
        else{
            grade='D';
        }
        return grade;
    }

    public void printReport()
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("                    REPORT CARD                      ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Name : "+getName());
        System.out.println("Phone Number : "+getPhoneNumber());
        System.out.println("Marks : "); 
        for(int i=0;i<Marks.length;i++){
            System.out.println((i+1)+" - "+SubjectName[i]+" : "+Marks[i]);
        }
        System.out.println("\nTotal Marks : "+getTotalMarks()+" Out Of "+Total);
        System.out.print("Percentage : ");
        System.out.printf("%.2f",getPercentage());
        System.out.println(" %");
        System.out.println("Grade : "+getGrade());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println("-----------------------------------------------------");  
        System.out.println("           Generated On : "+dtf.format(now));
        System.out.println("-----------------------------------------------------");
    }
    public static String convertTitleCase(String input){
        StringBuilder output = new StringBuilder(input.length());
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase && Character.isLowerCase(c)) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }else if(Character.isUpperCase(c))
            {
                c=Character.toLowerCase(c);
            }
            output.append(c);
        }

        return output.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Students : ");
        int n = scanner.nextInt();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter Name : ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Enter Phone Number : ");
            String phoneNumber = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Number of Subjects :");
            int subjectNumber = scanner.nextInt();
            String subject[]= new String[subjectNumber];
            double marks[]=new double[subjectNumber];
            System.out.println("Enter Subject Name Then Enter Marks of that Subject : ");
            for(int j=0;j<subjectNumber;j++)
            {
                subject[j]=scanner.next();
                marks[j]=scanner.nextDouble();
            }
            name = convertTitleCase(name);
            Student ob=new Student(name,phoneNumber,subject,marks);
            ob.printReport();
        }
        scanner.close();
        
    }

}

