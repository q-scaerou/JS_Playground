/* **Program description**
    This program will display the text written by the user in the console as 
    a comment. To add stylistic improvements, each word is displayed on a 
    distinct line. The whole result is in a table framed with // so it appears
    as a JS line comment.
*/

// Declaration of a variable used to dimension the table (btw. 50 and 100):
var width = 80;

// Condition to deal with uneven 'width' value that creates a gap:
if (width % 2 != 0) {
    width--;
}
// This condition checks the width of the table:
if (width < 40 || width > 210) {
    console.error("Error: Your table doesn't meet size requirements.");
    console.error("Value of var 'width' must be over 40");
    process.exit(1);
}

// This condition checks if the user has given an input:
if (process.argv[2] == undefined) {
    console.error("Error : You must type some text or numbers.");
    console.error("Use command $ js p1.js <argument> [<argument>...].")
    process.exit(1);
}

// This condition checks if the user input is too long:
for (f = 2; f < process.argv.length; f++) {
    if (process.argv[f].length > 9000) {
        console.log("Error! IT'S OVER NINE THOUSAND !!!")
        console.error("Your text can't exceed 9000 chars.")
        console.error("Perhaps you should consider a Text Editor? :)")
        process.exit(1)
    }
}

// This function allows to repeat a string n times:
function clone(char, iteration) {
    out = ""
    for (a = 0; a < iteration; a++) {
        out += char;
    }
    return out;
}


// This function allows the slicing of an oversized input.
function textSlicer(text, nSlices) {
    var startChar = 0
    var endChar = 0
    for (b = 0; b < (nSlices - 1); b++) {
        var out = "";
        var emptiness = width - text.length
        startChar = endChar
        endChar += text.slice(startChar, (width - 8) + endChar).lastIndexOf(" ");
        out += text.slice(startChar, endChar);
        var emptiness = width - out.length
        leftVoid = clone(" ", ((emptiness - 4) / 2) - out.length % 2);
        rightVoid = clone(" ", (emptiness - 4) / 2);
        if (("//" + leftVoid + out + rightVoid + "//") != ("//" + clone(" ", width - 4) + "//")) {
            console.log("//" + leftVoid + out + rightVoid + "//");

        }
    }
    startChar = endChar
    out = text.slice(startChar);
    emptiness = width - out.length
    leftVoid = clone(" ", ((emptiness - 4) / 2) - out.length % 2);
    rightVoid = clone(" ", (emptiness - 4) / 2);
    console.log("//" + leftVoid + out + rightVoid + "//");
}

// This function centers the text in the void between // _ //
function formatText(text) {
    nothingness = width - text.length
    leftVoid = clone(" ", ((nothingness - 4) / 2) - outSmallLength % 2);
    rightVoid = clone(" ", (nothingness - 4) / 2);
    console.log("//" + leftVoid + text + rightVoid + "//");
}

// Display the table top border with //////...
console.log(clone("/", width));

// Display the comment writer(user directory):
var wDir = process.cwd();
wDir = wDir.slice(wDir.indexOf("/", wDir.indexOf("/") + 1))
wDir = wDir.slice(1, wDir.indexOf("/", wDir.indexOf("/") + 1))
var blackHole = width - 12 - wDir.length

// Display an empty line under the top border (less compact):
console.log("// " + "User : " + wDir + clone(" ", blackHole) + "//");

// Display "----" at the beginning of the paragraph comment:
console.log("//" + clone(" ", (width - 8) / 2) + "----" + clone(" ", (width - 8) / 2) + "//");

// Display "----" at the beginning of the paragraph comment:
console.log("//" + clone(" ", (width - 12) / 2) + "--------" + clone(" ", (width - 12) / 2) + "//");

for (c = 2; c < process.argv.length; c++) {
    if (process.argv[c].length > (width - 8)) {
        var nSlices = (process.argv[c].length / (width - 8));
        var out = textSlicer(process.argv[c], nSlices + 10000);
        console.log("//" + clone(" ", (width - 12) / 2) + "--------" + clone(" ", (width - 12) / 2) + "//");
    } else {
        var outSmallLength = process.argv[c].length
        var outSmall = (formatText(process.argv[c]));
    }
}

// Display "----" at the end of the paragraph comment:
console.log("//" + clone(" ", (width - 8) / 2) + "----" + clone(" ", (width - 8) / 2) + "//");


// Display the date of the comment in the low right corner
var today = new Date();
var year = today.getFullYear();
var month = ("0" + (today.getMonth() + 1)).slice(-2);
var day = today.getDate();
var todayDate = year + "/" + month + "/" + day
console.log("//" + clone(" ", width - 17) + "(" + todayDate + ")" + " //");

// Display the table low border with //////...
console.log(clone("/", width));
