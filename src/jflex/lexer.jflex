package lexer;

import types.*;

import static types.OperatorTypes.*;
import static types.LiteralBoolTypes.*;
import static types.KeyWordTypes.*;
import static types.DelimiterTypes.*;
import exceptions.NoSuchLexemeException;
%%

%class Lexer

%unicode

%line
%column

%type Lexeme
%{
%}

EOL = \x0D | \x0A | \x0D\x0A
Space = {EOL} | \x20 | \x09 | \x0C
NotEOL = [^\x0D\x0A]
Commentary = \/\/{NotEOL}*
Symbol = [a-z]

NonZero = [1-9]
Digit = "0" | {NonZero}
Underscore = _
Underscores = {Underscore}+
DigitOrUnderscore = {Digit} | {Underscore}
DigitsAndUnderscores = {DigitOrUnderscore}+
Digits = {Digit} | {Digit} {DigitsAndUnderscores}? {Digit}

Identifier = ({Symbol} | {Underscore}) ({Symbol} | {Digit} | {Underscore})*

Integer = "0" | {NonZero} {Digits}? | {NonZero} {Underscores} {Digits}

ExponentIndicator = e | E

Sign = "+" | "-"
SignedInteger = {Sign}? {Digits}

ExponentPart = {ExponentIndicator} {SignedInteger}

Float = {Digits} "." {Digits}? {ExponentPart}? | "." {Digits} {ExponentPart}? | {Digits} {ExponentPart} | {Integer}

%%

({EOL} | {Space})* {}

"(" { return new Delimiter(yyline, yycolumn, yycolumn + yytext().length(), LEFT_PAREN); }

")" { return new Delimiter(yyline, yycolumn, yycolumn + yytext().length(), RIGHT_PAREN); }

";" { return new Delimiter(yyline, yycolumn, yycolumn + yytext().length(), SEMICOLON); }

if { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_IF); }

then { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_THEN); }

else { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_ELSE); }

do { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_DO); }

while { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_WHILE); }

begin { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_BEGIN); }

end { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_END); }

read { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_READ); }

write { return new KeyWord(yyline, yycolumn, yycolumn + yytext().length(), KW_WRITE); }

true { return new LiteralBool(yyline, yycolumn, yycolumn + yytext().length(), TRUE); }

false { return new LiteralBool(yyline, yycolumn, yycolumn + yytext().length(), FALSE); }

"+" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), PLUS); }

"-" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), MINUS); }

"*" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), MUL); }

"/" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), DIV); }

"%" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), REM); }

"==" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), EQ); }

"!=" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), NEQ); }

">" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), GT); }

">=" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), GEQ); }

"<" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), LS); }

"<=" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), LEQ); }

"&&" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), AND); }

"||" { return new Operator(yyline, yycolumn, yycolumn + yytext().length(), OR); }

{Commentary} { return new Commentary(yyline, yycolumn, yycolumn + yytext().length()); }

{Float} { return new LiteralFloat(yyline, yycolumn, yycolumn + yytext().length(), Double.parseDouble(yytext().replace("_", ""))); }

{Identifier} { return new Identifier(yyline, yycolumn, yycolumn + yytext().length(), yytext()); }

[^] {throw new NoSuchLexemeException(); }