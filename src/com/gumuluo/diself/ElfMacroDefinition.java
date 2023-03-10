package com.gumuluo.diself;

public enum ElfMacroDefinition {
    PT_NULL(0), PT_LOAD(1), PT_DYNAMIC(2), PT_NONE(4), PT_SHLIB(5), PT_PHDR(6), PT_TLS(7),
    PT_LOOS(0x60000000), PT_HIOS(0x6fffffff), PT_LOPROC(0x70000000), PT_HIPROC(0x7fffffff),
    PT_GNU_EH_FRAME(PT_LOOS.getValue() + 0x474e550), PT_GNU_STACK(PT_LOOS.getValue() + 0x474e551),
    PT_GNU_RELRO(PT_LOOS.getValue() + 0x474e552), PT_GNU_PROPERTY(PT_LOOS.getValue() + 0x474e553),
    PT_AARCH64_MEMTAG_MTE(PT_LOPROC.getValue() + 0x2), PN_XNUM(0xffff), ET_NONE(0), ET_REL(1),
    ET_EXEC(2), ET_DYN(3),  ET_CORE(4), ET_LOPROC(0xff00), ET_HIPROC(0xffff), DT_NULL(0),
    DT_NEEDED(1), DT_PLTRELSZ(2), DT_PLTGOT(3), DT_HASH(4), DT_STRTAB(5), DT_SYMTAB(6), DT_RELA(7),
    DT_RELASZ(8), DT_RELAENT(9), DT_STRSZ(10), DT_SYMENT(11), DT_INIT(12), DT_FINI(13),
    DT_SONAME(14), DT_RPATH(15), DT_SYMBOLIC(16), DT_REL(17), DT_RELSZ(18), DT_RELENT(19),
    DT_PLTREL(20), DT_DEBUG(21), DT_TEXTREL(22), DT_JMPREL(23), DT_ENCODING(32), OLD_DT_LOOS(0x60000000),
    DT_LOOS(0x6000000d), DT_HIOS(0x6ffff000), DT_VALRNGLO(0x6ffffd00), DT_VALRNGHI(0x6ffffdff),
    DT_ADDRRNGLO(0x6ffffe00), DT_ADDRRNGHI(0x6ffffeff), DT_VERSYM(0x6ffffff0), DT_RELACOUNT(0x6ffffff9),
    DT_RELCOUNT(0x6ffffffa), DT_FLAGS_1(0x6ffffffb), DT_VERDEF(0x6ffffffc), DT_VERDEFNUM(0x6ffffffd),
    DT_VERNEED(0x6ffffffe), DT_VERNEEDNUM(0x6fffffff), OLD_DT_HIOS(0x6fffffff), DT_LOPROC(0x70000000),
    DT_HIPROC(0x7fffffff), STB_LOCAL(0), STB_GLOBAL(1), STB_WEAK(2), STT_NOTYPE(0), STT_OBJECT(1),
    STT_FUNC(2), STT_SECTION(3), STT_FILE(4), STT_COMMON(5), STT_TLS(6), EI_NIDENT(16), PF_R(4),
    PF_W(2), PF_X(1), SHT_NULL(0), SHT_PROGBITS(1), SHT_SYMTAB(2), SHT_STRTAB(3), SHT_RELA(4),
    SHT_HASH(5), SHT_DYNAMIC(6), SHT_NOTE(7), SHT_NOBITS(8), SHT_REL(9), SHT_SHLIB(10),
    SHT_DYNSYM(11), SHT_NUM(12), SHT_LOPROC(0x70000000), SHT_HIPROC(0x7fffffff), SHT_LOUSER(0x80000000),
    SHT_HIUSER(0xffffffff), SHF_WRITE(0x1), SHF_ALLOC(0x2), SHF_EXECINSTR(0x4), SHF_RELA_LIVEPATCH(0x00100000),
    SHF_RO_AFTER_INIT(0x00200000), SHF_MASKPROC(0xf0000000), SHN_UNDEF(0), SHN_LORESERVE(0xff00), SHN_LOPROC(0xff00),
    SHN_HIPROC(0xff1f), SHN_LIVEPATCH(0xff20), SHN_ABS(0xfff1), SHN_COMMON(0xfff2), SHN_HIRESERVE(0xffff),
    EI_MAG0(0), EI_MAG1(1), EI_MAG2(2), EI_MAG3(3), EI_CLASS(4), EI_DATA(5), EI_VERSION(6),
    ES_OSAABI(7), EI_PAD(8), ELFCLASSNONE(0), ELFCLASS32(1), ELFCLASS64(2), ELFCLASSNUM(3),
    ELFDATANONE(0), ELFDATA2LSB(1), ELFDATA2MSB(2), EV_NONE(0), EV_CURRENT(1), EV_NUM(2),
    ELFOSABI_NONE(0), ELFOSABI_LINUX(3), EM_NONE(0), EM_M32(1), EM_SPARC(2), EM_386(3),
    EM_68K(4), EM_88K(5), EM_486(6), EM_860(7), EM_MIPS(8), EM_MIPS_RS3_LE(10),
    EM_MIPS_RS4_BE(10), EM_PARISC(15), EM_SPARC32PLUS(18), EM_PPC(20), EM_PPC64(21), EM_SPU(23),
    EM_ARM(40), EM_SH(42), EM_SPARCV9(43), EM_H8_300(46), EM_IA_64(50), EM_X86_64(62),
    EM_S390(22), EM_CRIS(76), EM_M32R(88), EM_MN10300(89), EM_OPENRISC(92), EM_ARCOMPACT(93),
    EM_XTENSA(94), EM_BLACKFIN(106), EM_UNICORE(110), EM_ALTERA_NIOS2(113), EM_TI_C6000(140),
    EM_HEXAGON(164), EM_NDS32(167), EM_AARCH64(183), EM_TILEPRO(188), EM_MICROBLAZE(189),
    EM_TILEGX(191), EM_ARCV2(195), EM_RISCV(243), EM_BPF(247), EM_CSKY(252), EM_LOONGARCH(258),
    EM_FRV  (0x5441), EM_ALPHA (0x9026), EM_CYGNUS_M32R (0x9041), EM_S390_OLD (0xA390),
    EM_CYGNUS_MN10300 (0xbeef),
    ;

    private long value;

    ElfMacroDefinition(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static byte ELF_ST_BIND(byte st_info) {
        return (byte) (st_info >> 4);
    }

    public static byte ELF_ST_TYPE(byte st_info) {
        return (byte) (st_info & 0xf);
    }
}