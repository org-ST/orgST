package org.orgst.channelapps;
import java.util.Scanner;
import org.orgst.Variables.Ops;

public class CTPorted {
    public static String[][] ans = new String[0][];

    public static void start() {
        System.out.println("CalcTrash V1.0.3 by @Table");
        Scanner cScanner = new Scanner(System.in);

        while (true) {
            boolean found = false;
            System.out.println("Input operation, else, enter \"help\" for all commands");
            String c = cScanner.nextLine();

            for (Ops.op o : Ops.ops) {
                if (o.hasName(c)) {
                    found = true;
                    String[] opTD = new String[o.info.argCount + 1];
                    opTD[0] = o.info.opName;
                    Scanner opScanner = new Scanner(System.in);

                    for (int i = 0; i < o.info.argCount; i++) {
                        System.out.print("Please enter a number: ");
                        opTD[i + 1] = opScanner.nextLine();  // Fix: Start from index 1 for arguments
                    }

                    String out = null;
                    try {
                        switch(opTD[0]) {
                            case "add":
                                out = Double.toString(Double.parseDouble(opTD[1]) + Double.parseDouble(opTD[2]));
                                break;
                            case "subtract":
                                out = Double.toString(Double.parseDouble(opTD[1]) - Double.parseDouble(opTD[2]));
                                break;
                            case "multiply":
                                out = Double.toString(Double.parseDouble(opTD[1]) * Double.parseDouble(opTD[2]));
                                break;
                            case "divide":
                                out = Double.toString(Double.parseDouble(opTD[1]) / Double.parseDouble(opTD[2]));
                                break;
                            case "exponentiate":
                                out = Double.toString(Math.pow(Double.parseDouble(opTD[1]), Double.parseDouble(opTD[2])));
                                break;
                            case "squareRoot":
                                out = Double.toString(Math.sqrt(Double.parseDouble(opTD[1])));
                                break;
                            case "lastOp":
                                if (ans != null && ans.length > 0) {
                                    Scanner lopScanner = new Scanner(System.in);
                                    System.out.println("How many operations back?");
                                    try {
                                        int idx = Integer.parseInt(lopScanner.nextLine());
                                        int ansIndex = ans.length - idx;
                                        if (ansIndex >= 0 && ansIndex < ans.length) {
                                            System.out.println("Value: " + ans[ansIndex][1]);
                                        } else {
                                            System.out.println("Error: that far back isn't stored.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid input.");
                                    }
                                } else {
                                    System.out.println("No previous operation available.");
                                }
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Invalid operation or arguments.");
                    }

                    if (out != null) {
                        System.out.println(out);
                        // Store result in 'ans'
                        ans = java.util.Arrays.copyOf(ans, ans.length + 1);
                        ans[ans.length - 1] = new String[]{opTD[0], out};
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println(c + " Not Found");
                System.out.println("Available operations:");
                for (Ops.op os : Ops.ops) {
                    System.out.println("- " + String.join(", ", os.name));
                }
            }
        }
    }
}