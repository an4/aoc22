fun main() {
    fun getPriority(c: Char) : Int {
        if (c >= 'a') {
            return c.code - 'a'.code + 1
        }
        return c.code - 'A'.code + 27
    }

    fun findDuplicate(s: String) : Char {
        val cArr = s.toCharArray()
        val size = cArr.size
        val set: HashSet<Char> = HashSet<Char>()
        for (i in cArr.indices) {
            if (i < size/2) {
                set.add(cArr[i])
            } else if(set.contains(cArr[i])) {
                return cArr[i]
            }
        }
        throw Exception("Duplicate not found!")
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { getPriority(findDuplicate(it)) }
    }

    fun findBadgeItem(a: String, b: String, c: String): Char {
        val setA: HashSet<Char> = HashSet<Char>()
        val setB: HashSet<Char> = HashSet<Char>()
        for (c_a in a.toCharArray()) {
            setA.add(c_a)
        }
        for (c_b in b.toCharArray()) {
            if (setA.contains(c_b)) {
                setB.add(c_b)
            }
        }
        for (c_c in c.toCharArray()) {
            if (setB.contains(c_c)) {
                return c_c
            }
        }
        throw Exception("Common character not found")
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for(i in input.indices step 3) {
            sum += getPriority(findBadgeItem(input[i], input[i+1], input[i+2]))
        }
        return sum
    }

    val rawInput = "GGVGlqWFgVfFqqVZGFlblJPMsDbbMrDMpDsJRn,LwzHtwdLHHwDrzPZzzsJbJ,wdLTBvSvHvZVGCjhfN,HsSSnZVHjjssZnJpSJjBHHWgQGcgqqQLQdQFqNgWgqGNDg,rmmRwrtfThtTrbCrGGGcLBDTqDBNQLdL,mwPrrbzPfwvbzhwMMnnjHnBjZlnzMM,gjjdMBgdqdTpJpBcjgRRRlqnvrqfnZtrtZDw,zHShWLhCszCWHVbVzQWCPtQvNZRwtfftfNnrnftlfR,PzPSssHbVhCLFMJFcMFJJMjdJw,ZqJdtpfpjmpJjpnwWdttTCDLLTQFNTzTzrcqrQqc,MsSlBGvBsSGGSlbGsCgggNTgzNLczFQNrNQVQcFzFF,sGHHSGllhvMGhSRGCjtjtjnjnnmHWpWWtJ,tMdjQlHPHsGjsCtsCpwwqfhfnnFMDMrpfD,SbNvWvBRJRWwFSgppgSrfg,RNcNbvzJRcVLRVzTRFLjdHCQttdZdPlHstPl,QWqgpdBflpHNCNWNHHPm,VVMbbJsLFVMhrMJMmRjFNHwHjjCTGSSRFj,mbMsZzsLmVhJZrcLcJhLMtnqvBnZdggplDffvlnlvnDn,prnNnsFnZpnBNdNtFrNnzNQQwTTQZqTHTQJQMwHDMDlZ,jgfgcSmbLmhmcPShghRdmwJTQjTlqGlJQJHqQqGHqQ,hRVhPfbCgbVggLVRSSmRhRPhrrrnCzzsvCvrnvFnNppsvBtd,QJLNDWSWQdLFFFhLdt,npHhHMsfsjpZjznRtmrMCdBwFBFrBdmt,HsjHqRRfnnHRsgfHffZspgzqDGQSWbQTDNGhQhSqNPhDWWbT,bsCmFDsGZCNsDmLDLZBSHSJTHnrZQMQSSQ,jqRpwvfqnnRQrftdBMHddB,phpchwpzjpvwRzwcsnlFsssPCCGzDlsD,rMqzVQfrfVZWZhTdRTQL,cgmtFtjFFJDDtFvSFRZdLlhpHZddmwTZWh,FbcSTtctcvFTJNgtJDGNPnCqMPMfMBfznGVsrMCq,wLJfGJJPZLBfwSLGHbqmhhDHHhFDzfhv,FsnpFjVjplTQCspNlCDbzhMMbqvMvsgmHDqb,lRdlTdTddllpRQFRltVVdFRcwrtrcWWcPrrWPrPSrZWLPc,VGVZhTppGTfPnJVJrFqbsmbSSshHqWqRHF,llzDCzlBLdNcCddlMMNBdCCtWHbFqFRRRsHjWtRwSWqbmjWm,NbcMBBvzzMQLCDBVTQQPVrPQPPZVPp,cdcgfmQdqlqhzzPjzfwpwf,GLBGBDvbvRzGwtnnmPpp,ZRCZBRFSRvLRLFvvbLLFQdHMTHTlQlNqNmqFlWdH,vzjzvHtcHvJcDStLLGSShCbbfF,MWFFTVZRMmMgdQdSQLwQrQwbGw,gFTmgmVZssRsWZRNzJlBHHnnJDvzNPlP,rHrvHpmHZfdGDDGGZd,cTlMsNhllMhGchNPCBlhMQgVDdgDSSWVbWVwRQwRSgbV,lnBjnNNTTMnCTcChPNhMvtzvFGLtJrjFtHHHzHJm,lgpdZZMmGVVzVZzt,HfHLrHqbPbzJJzRJJPTl,HsLWWbDqFrqlqfbsbDqDBncpgFmmvpnmmgpvdvjcdM,GpNVbTpJJNvMBMVvJTGvhnWQQScllnhhWlhVSznV,ZjswwHHLZzGnjWjSjl,sHdftLLtgLfwdtPmHtMbNpMTpNqGRbPvTqPv,sHSNNhNwsllGSGGlWSGWSsFrrVbQrdmFrVrrmnrHmrHr,QQMRZDDRcrcnmRcV,fJfCPMJCzTMZSGsWwsWBwqQf,HwQZZJsHdqqsdJQGRgCgVGgSqgpcGG,ljWWbnPhjBlGpCRCnScSGg,hrrztWlbPjltjMPSdJDZSsHttwsZwD,VzzbmzvpvNhvBDqc,QHSJSQGCwJCGrGQjjcgcBFhdgqdqFdDNNw,rCGJtZrHhhtLRsth,TMWwCLPpMTThrvtMRJjbjRvmJs,fDzcHFfSfFQfZzZRJbdmmqqssqtbSW,WWgGZglcllgPBBCBNVGPNr,wrwwhpTpbqhqrshrrfrFfwfzRJGdNJHNmcFzCCzCRJGzGR,vMggvjQvgPvQjVLMMPSZqWNJGCzcNGdcdzHPPzcmCzPz,qDZWvBZVfDhbTtrp,LpDvHdjVghnjbGrn,FBBBPwwlBlwSfFTWPHPWWhmgngmmnPnmbsngngbGrb,FwftBSCSfWCtwfVQDvHHCMVvdQLQ,ZrQpQlSpNlqQCVnQBmdDqmWDqmWWBDBB,HsZMsJvZzLMHTRwWhgDwmfDBgdhWdf,RZvTzJGzRjFrVNVjlQrS,mqjMwfqlSSPmSrlPhwhVpGRcppWcpcGRcGWv,ssJDJJNgZNDWrRWcRpvr,ZTsTnnsLJQgPnfMwmnMrfm,qsVBvZqWLdfbfvLj,mPNRgmHBBGQrCbSbrdfCCSbC,PlQTGcTTcgGFQQGPTGllpqMzwzpVJZwBMssZ,FWGcNRLRLhwJJQfV,nzbzlDBHSpTDbpDpzHwCqhqwJJghQqQMCCBw,JnzndzpmJFmNsrrFsc,gmRwwDwfnRDJgwZLFQFFNGNQrFBmFbbm,CCVHVWWThSrjVGvbNj,WpdqpplppHCWzlClMMTTZJcJsdscJLLdbDDfZDgL,VNtCCMDllpBqDvtdCczTSgjHlzGSHSGZTZ,hPFPsQhhFhLnbsRnLFssdzcHdsSHSSHgjzHG,QPWPQrPPmbdnbWLFPrrBVrVDBqqNMVwttDtBvD,PPNNRggwgRRgHBhDtwhTwbDs,SFGSFSMCJFMrcrCMSSsbtrTbbZhBvtHhrTHD,MFfSMpflQLQflfLjnLmddsLdddqq,RcgbcrrFscVrwZVCgVGGmHppNNndWnGdNqddqqNqND,jTlSTBSTjLTvlvjjPtvMLlhHnftphtDFNFqDnDHWNddn,QBMQvzzjzvJPjFQMmwZJrgmCCJVRVbbc,CzPJsWCpvsNszsJsNsHlDhMrrJGjhrRVhRGgDDjG,tFFdbqFLFdwctQdfVhjRRghTcrjVRTDW,bwQtFLdLBdFmwnHnWHPBNnHCnp,CNTstGNslRRRstlmNmmTZZqfFwtqgwqgfBPSwSWwqgWq,hpDbcHbpSrcgqqzhhWVfqg,DDcLDjbMjCSsZRNlMv,MhHMCMNbzbMHlcqmGmrmWc,tnPggdZPBPgdtttJpdnwVBnmqQcvlQrQlfGqmfWffBcqWD,VPPwPPLPwLGFGLzCbG,rqBcBmjHTGfPbcVgPG,dlDpsdshzlldlDvsWlWvLQbQBbfLFLbPvbBGQBgG,BlBznnRWzlphphBnhZjZtNNCNmrNqjCqHwHN,mQBvmvBmmLJvvrLtttQrfhGlcRGfRhVGWJVChlRG,MzPswTsbTPPsNgMNszgzMpbMfcRcGflVGRfWSpFRlWWWFhcC,bcPsTbgbbTTwNZzTZzvdjdjtQQndZvdrvdmZ,hQzTQJFFZJrcdcdZFFrGFSVWVRWRwRgRHVMWDCDSWc,lPmpNBnnnsNBnLnfbfnCDWMvwRvDCCMPwwHWvM,HpjmffNlnqqhddTddFZjGJ,BwsLFFbHLbVCSCSFbsbFLsJbqnTtZrRMHTZtrTrZTcRRRRTq,lGhNhpPmmhpztZTBrcpjRqpB,QPzdfzBQNgFJSCwsdLbS,ZsZsSBTgffSCqSSfrMnnMwjqmqmnnnqwMm,bbPPbzVclcPzGNlvzVtmnDBnQmtnQLBjJVLn,zPFGplGGvdPbHplcbzzvdlNBTThgRpCTCTfhfsCCsSRZhR,CVLSVCLVZRsHcnzSRpdZZRCdPlmcMWDDlPNqMqtDMmqPMlDt,TBnGjfQrQJjhfWlPPmPQDNlmlP,fjhhGvjvvrTTBhvTBTbvGVRLzVnbSRZpHddspHRzLs,DDtWjfRfftWMLzSQjzzhWjjwRVPHqFbBbZHVwZBFvFwZvZ,JGllgCJlJsrCGPrCNTPdslvZVVNVbvBqNbbpbbFHpBwZ,CcPdnCdmCJjfcftWhtSL,pgpfddDGHWzDNGNGpRCQjCTFHZZQFQjcRT,bJlhqmMvnlrRQFtTthPVhZ,lvbJrlJMBwfzGNTddB,wpbJGGZpsjvtdWvGWF,HqqhBhBqhhNQHTSHqqNzRHVPvTvddWrjtrjFvrvdTdVP,NRLCRzlqHQtNRBLzQllhhZcgbggwmLDZpsgssDpwwD,pDzFzJFcVMcWJFJFzpLBsqWLZssshsGLGbsS,wqHqfvnfrRwQtdQRthhBbBbZLhPLnBTGsh,CfQqlqvtfHNvMVmzmmMCFDMc,GcgpNHvcSNvpSLphdhsLdQTsdWThhQ,wwzttPrrhQswdhnT,tjJjMJRbRbjztmjtjbgcRsNlgglHpDFSlSvg,VVLvLqqPVlvcqLLdwLbHpzcHSsbRJppHbHpF,CfjjCNGmMWhWjhWHWb,ZmGZffggrDqZvZtlbTqL,TTmmhvBvvHWzHpsPpstpLVdwwsLb,qflfFgNctNcCnCCNDnfFFNDwrslwZbPswwZbJLJZbrlPLL,FgQDDcncStCgtqccjSDTHWMThvhTQMBQhWvWRG,SqhVghPccSBhgSBqWBFNQNsHQHMjCCQQWCwQHN,fLZftnlttcbbtZbZlpZtttQjwsCQjRwwRDQspMRMNNQs,TfLtvbJtZmlbTTTtlJbFvVqPSgBdPqPhFSGBcd,pPPNDptcqtpcDztLDhhngnnJgJTmJwNnwm,HVVCsSClHGBCHslWHbSCGGVngTrJwnnJnQRRBrhQhgJhdm,WTWWWsvVlvGbWCFvjDftPpjqZLLtDz,wWclwtDwRvflvffB,sMMsGdsSTMrJZNqczfdvhvnzCnfv,rspppMjMspSTSMpgLjcPFmwPLmPHwb,tCdSMHtHtRFHdWSSJQSgrrrnghTNJN,BGfcvDsfvsqcvqfGvfGnNLhggBNQJNJQmpgQJm,sGfQDPDZzfDZzclwDzwsDlfjtbdHClFRCMWjbMFMRFWbdj,pJNCcvqCccsVvFCpqsmvWJfCBWgSzBBRrrBRDDgDrSbbgQbQ,TMLnLjjffwfwGdjQjDDBjBrDtztRSb,MdPLGhHnMZhlPHHTFfZvVCpmmmcFcVFC,SwFMfCMRCdQDdMbmdFfdbbnlcVncVCcgLqWcNNnCcWlW,hPjQzzhGzhpPrtPJPpPHrVgnqVVncVVnNHlqVnncNB,ptjGrptztpthtrtJJhTsGwFDZZDQmSdfZSwsRZSwfZ,rSSWWCWrdllHWpjcnFNnRCNjQp,bGwwJqGVGbGJVVhgbBgttGmBQjFsMjpMcMnnMBcQFNnsssvv,bfthwmfJfgwwmmwZqVJPHNHSZHWzSlDPrdDdSH,nmJccvclcbwmlbbvVbvsHwJJPCPNCNPnLBhrBPPLBhLhBgBP,MdRGtdDRTqWDMqtMDtQDRWSdLLBsrhLgBCgrgCgNNLPBfNMf,dRZQdDdRRSQWGsjZmwzjmlzsZH,PBGGMrTQTrTBpPQpLpSlwjwfjtlnfwbmGttw,fCsJCWJcvRCtwwjbCl,NsqcsfcvDHFVDJvdLQTrpdTTzTPpHr,rltrwsBTlrfGZggGBLGGNN,jhMnRQJVphMnbhvQjDZNqqZDNTNHZVHGHq,MRvbhQRQQChpvbjvMSvQnMcsFsfwwmlCwFwWcTWwrmPc,DDvLLLBnvrzvbvbmtv,TMwRjTRMGCwGGwrjQQnmrQrrQdhZ,MJPFHFTwgCGqGqgJMGDfSWcsnBSccgVDlnpW,flzVzNrdLNLJzrGlfdlzjrQDgFTpDgDmmmgFmqFDQjQh,CbnBcsZnPZVSnwvVsZbRhhBDpgFphgmgDgTppq,ZWnsWSnncSZsntZCbsswwJMzdLzlMdNMLtMVfrllMt,ZffSgNfgJgGCHZcZrpHrNJTLhqvSLTqQnvVTLvzvLTjV,tWFtHMwlBlDqjjzjnqvvlV,DRMPDtWHPFDBFFwWMFBmFRPgZpJfsffNGJNrGcsprrsmfg,wRZRmpZmlPqZjzGrdrGq,bBhQQFPQbPDVNzVNzdGWNdrf,QFbcDcDbLHgHBPDFRsSSMtmvRttMpCLS,MpWJVVJMcWvpRShcwpLGflmqzSfNdfNLdQzN,CDBTtCgtbjgCRrBrPBTQqzflNqjGdLzzmqffzq,rFgnnBbttDTPtHCDPrPMnpwVJhJvMZvpMvppRZ,sWTTmpsfsWppPTTsTVZWHVVZNvVcdcJvdN,DjjBzjhRHvvvSzdc,rMBjjrjbjrGDlgMlMrGjBgRLPTTwHMsfnFwFQPMPMnmFFm,QRRbDjjmPzNQwFDNmrQmzCbVHrMhBVrJLJJfMGGLtfJBHh,dsWcsqqWSWvnWnWcWGPJLBqhLBqGhBJHHH,ZWnPWgWgPnlbCDDwmmDbRZ,nfPqqfLqQnfHBSqnzztQjVmjfGRWJNGRWsJWJfmJ,TTMlMMlFDMGVGRsVJH,CbDbFDbvgTFFwgTDlDprhlPSqBzSnPdLPtPPHgznQqBQ,fJmWVfHqjfjhZCQZ,NcNzBNvgszQmzjnthZQC,LsLsgBNFmFgTFgGBBgcdMdvPDPDJWrlpVbGpJWqHDlHJHD,SllDdvzgdFDdlPJvbFDDSzFScPTRTNcwfZRwRhcwwNnRZTtf,WBpWBCLGVpLjHrHGGVhZNwcTVcNhVnRcNZ,LHLQLspHWQGpWCHnBvdzDJFlqvdsqgSgqS,GcTctDMjMhpMDRjLsMMsfDWFfdPCFNbnCPnvCPgW,JmvwqlBwnmfdFPFP,SvZqHSZqqHZZZBlllBwSwsRsMHpLjpLsMGtsMspGRT,ClLnCLfClLVllfLLcQjLBCfCmSHVsttsmtsVStDNVdppdsSp,PFrRMbWqMRwFRqRSqwqvMvMsGtgsdmssrgNtdmpNdDGgdt,bwJbPWPwFFPFSczCZzZZCcfjBJ,MwmBmzwJQTcTmfPVfZPwhhwHPH,jlnrglFLvbrGRFGnvFZdNNFfPZddPThVhdPH,RjbjpgbnLGvpLgzBqBpmWmmzqTMS,FnsSpttPnPbNCFDtsPnFHQZTQZgcwgDDTfrfTHMZ,mRjzRzlvBvhjZrQmMMwfZZNN,ldzddlzLRlRWdhjdRLjhRWtJbJbNtJJpJPbCbGCWNG,wBwmNZBTmzzcVcmpzZqdMgPjnLSVlPgDPdbMdg,flJvGtHffHDddddbHjnb,RstrhfrhhRGFQtRhtftvQhvFZpsmpWwNlWqcWTccBNWswqNp,DPWhbzDlQLLlQbLDlLhPhLFNNJqCFGqnNJCCSCnGPnGN,wvwjtvtdwfssvSJgFFvGGSCFcp,mtdrZwwJsrtddrHRtZWbVThLlBzVTzhHQWhB,TsRRWctsTJMQZllggc,zDvhpbprgGvpvVlVQlZpQMJVlQ,rrrvFvGCDhDSrrrvChCgSstBNTSftWBjTdfWBN,JJdssBcLVGrgbBHWrH,QZTptvmvmlZpRDlMMMZCQvnjjFnrjWGFbjnrnFGWgZrz,TMRplDMggtwlppTlvhsJJqdcqwVPSSNcLd,JjTCCrcRvccPLmMP,NfGFPZlNnwBfPlbbbQZGqLHgzLghSmMBzSgvzmDMhv,ZfbnNQpQnZGlGlGpWTddjdTJdpRPTrCj,gWLblMMggdWsdRJlblMRMMqWDvPvcPPPccJPJVTZVZThmcDP,rQFfGfrCHrjnrtNTcPShTSPvvVLtmm,fQrCfLrpLHnCHwslqzqsslswzqRW,zpJtGlJPMPTlTjGJCDGCDljpdnvhhWnZnZnDwwmvnWDWWvdd,sHrVrSrRRRLNgLVBqSsZmWwvwcvwZjmwngmdbn,QsQQBrrLHTjPpTQzzP,JDlzHHzzptRDmbTMrrVQ,dRRNqnCBnmrQsVQQ,wFPCBNFgwjPwhgFNztftpJRPpzRvvHtZ,DlBhrDBPPwMWwhWchW,ntSqbbSJFJNqzVzjCfMvfSlSRWccRL,mVlHtNVtqldbJVmNHmdTTBBgrQQgGsPQdrDgsP,HWHNbBgvNLdcvQMnSf,wqqqVPDPhqwszFwrrszFfMdWthLcMdfhthSQfJSt,qVPVwTzFwFDpDrPDzDPFDPlCHjBGjTmZGjbWWGZBRTNjjH,GVgdWjllSqgjdgHqqlfmhwcpwCzhvZwMcScv,nsJQbLRQsNnzQDQQPPBbRBRhfZwpZcvwpvvmLCcvpcmfMM,DRJtnnRbBBnPztsrPzRBPbsFFHqqVrqggjFWqrgWjTGgFq,hhZJQPJFHGGlcWWslpNN,VwwwJjvwMtrCnwjDNDzlfscWszWW,nVStCrMqbVwqVqSqwnLPhTJFdRgJHZSFRLTP,vPgMbbRhhvMvNjjLWsWQsHQmHwBrmmBzww,tFctDnVFpppHVBTdzdTQwl,FtSFqSptfJCqqJStZCqDpDJMhvLLgLMgQgjgGZgGgMPLZg,zwsWgSGWLSVhPWhtLgLWhPVNQTmDrDQttZpdQtdpQDDQZQ,fjCHcvvjMDrppCQpVV,VMqRnVJMVLPzbRWhGh,mjRmzQlzDzNHWwDZ,FBfJBGqnnpfSVGnpJbJVfNtCsJHWZvrsNJCZrCNsvN,fZPBnfPqSBqdfpFbVnVSjgdcLLgRLjmgRhLLghlR,FSFnTcppdQtnnDhtzDfg,ZLGVmBLBVwZCVjjGqGhVwVVgzzbMDtNNvszMmMffNDDvtM,VZPJjBZVqBZZBjqwVqllpSTphhQFPShWSQcW,hTRdcLrCLgplLvBFGvlL,nZDZqzbDbDzRZtVNDzDWGwslsllBFpnlpGvJssFG,zbqjNWQVmVPrrRjRdRhS,VpNCbVHlHHZfflVfmchctqFcqQQjZmZM,WDSRGgsSvgJSRrnWgqQhmjBqmhqrtLqmQm,znSGTgDJnsDGzgwCwlpbCNwHzVtl,sTTTrpHFFFqTnQbbvfJdDzHHDLVV,CjMtgMgRvbPfjjvB,mhMvlhhWClvqshNTQQqsNN,tWFtFBzbwdFrpmdhdm,qTqDjJjJQQqMjTDLJjNqNqPNdmpcSmhdmhhmcrWZpdPGddcc,RjNQLJNTTJDDJRHHjQqnMWtlvvVvbtBvRVzgzgwgVg,CGdQjwdJrbBmpmZZZlRWcb,NgtMPVstgSzBLzhgzgLgDRlcmDWRmlZvcSmDSvvp,LhNsgPPLFPPsNzMhhVzPsGJBFqwQGfnqfQjdGdGfwr,CNbNdbzjCZpPNzjmzjsCMRJvnnMRGnsvJGRs,wrtdwTLWFcFWdFgwRRsnJGnGfTGJfMsq,FttcwgBtgVLgPldQSNZBzBpz,DjRZrrRmttRFDvDrFTZsnWnHVSTSSJVZJH,dNNhLqlLLqdCzfMMlCfSncTVVWcHdcVsVdSVnT,QqppMfzMfqWCwbRQrwFrrttQ,dwGjHrtjsdhfCHnPSpfMfDPpPDWS,lmNzzlLbFqcqNgzpWMSvbbvDQDGWDp,LBmglgmqBqmrwCGhCjVtBC,tvHgWZCCprlgpWglCtjPhLmPmhVdJFSzVzdJVmmQ,fBnTTnNNBnwfnNqcBbBBTbGJQQJhSSdQJJsmdJFSQGSmVV,cMcDwFbRfFRlHCRCZrrp,ZFWmgghzBgwgjWBzjzmRWWMmsVwnVrsdVdwNrrpnnVrPCnCP,GLLbtGqllctqvGJvSlQbJGsPnVdsdpsTPLsVppBCTVss,tJBStGSvctvDDfczmRgRZjzDjZmgzH,FMrLmsQQSWzCZBhpQJTQQZ,dPPVncVvPBJDCPhwJD,fvHbbVHvqnvvvBzgLbbGGmrbMr,mrZzrzqDrhZqDddSFrCGLLLPQPQBJPJJBnQq,TgbpGblWlMsjgWlgMfpNRgbRHHBnHHHtLpCJPCPBnBLJtQQL,sbTlblTlvRbbGblbFcdDzccVcDVvzzzd,zMzfzlGwSBMMSCMzhsPgfcPcfcbhjQPt,FHHqJVdJmFmdVrJdJppthscjGtqRPRcccgcQbR,rvNJJpLrvvLnJvNFFvZZZBWznBWGSDCMnCwz"
//   val rawInput = "vJrwpWtwJgWrhcsFMMfFFhFp,jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL,PmmdzqPrVvPwwTWBwg,wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn,ttgJtRGJQctTZtZT,CrZsJsPPZsGzwwsLwLmpwMDw"
    val input = rawInput.split(",")
    println(part1(input))
    println(part2(input))
}