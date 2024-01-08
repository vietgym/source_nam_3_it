code segment
    assume cs:code, ds:code
    org 100h

start:   
    mov ah,1
    int 21h
    
    mov cl, al 
    
    mov bl, 'A' 
LAP:  
    mov ah, 9
    lea dx, khoang_trong
    int 21h
   
    mov ah, 2 
    mov dl, bl
    int 21h
    
    inc bl  
    
    cmp cl, bl
    jl al_nho_hon 

    jmp LAP                 
                            
al_nho_hon:

    jmp end_if

end_if:  
    
    

khoang_trong db " $"  
xuong_dong db 10, 13, "$"

IN_END:
    mov ax, 4c00h
    int 21h  

ends

end start
