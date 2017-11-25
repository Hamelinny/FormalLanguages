grammar L;

block
    : statement*
    ;

blockNBraces
    : '{' block '}'
    ;

statement
    : function
    | expression
    | ifStatement
    | whileStatement
    | writeStatement
    | readStatement
    | assignment
    | returnStatement
    ;

function
    : 'fun' Identifier '(' parameters ')' blockNBraces
    ;

parameters
    : Identifier (',' Identifier)*
    ;

whileStatement
    : 'while' '(' expression ')' blockNBraces
    ;

ifStatement
    : 'if' '(' expression ')' blockNBraces ('else' blockNBraces)?
    ;

assignment
    : Identifier ':=' expression
    ;

returnStatement
    : 'return' expression
    ;

readStatement
    : 'read' '(' Identifier ')'
    ;

writeStatement
    : 'write' '(' expression ')'
    ;

expression
    : functionCall                                           #functionCallExpression
    | Identifier                                             #identifierExpression
    | Literal                                                #literalExpression
    | '(' expression ')'                                     #expressionWithParentheses
    | '-' expression                                         #minusExpression
    | expression op=('*'|'/'|'%') expression                 #binaryOperationExpression
    | expression op=('+'|'-') expression                     #binaryOperationExpression
    | expression op=('>'|'<'|'>='|'<='|'=='|'!=') expression #binaryOperationExpression
    | expression op='&&' expression                          #binaryOperationExpression
    | expression op='||' expression                          #binaryOperationExpression
    ;

functionCall
    : Identifier '(' arguments ')' #identifierFunctionCall
    ;

arguments
    : expression (',' expression)*
    ;

Identifier
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

Literal
    : [1-9] [0-9]*
    | '0'
    ;

Space
    : [ \t\r\n] -> skip
    ;
