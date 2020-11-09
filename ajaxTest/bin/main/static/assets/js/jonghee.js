/**
 * ajax 통신시 사용될 기본 로딩 이미지 설정
 * 
 * @returns
 */

// 26. ajax 통신시 사용 2
function getLoadingBase64Image() {
	return "data:image/gif;base64,R0lGODlhQAFAAfMAAP///8bX64Sq1bbM5pq53DZ1u1aLxtjk8eTs9bzR6B5lswRTqwAAAAAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YILCAAtIOCBQoqHEDwc4CACguiUggwYIBPBAoUGKAQdcEEBFUT/MyqwKqErhMSVD3wU0DWAhPQAjgQtmiBrE8ByK06gCnQAWSZoqU7IAAFwn5jDihQgOgEA3gtgP2qdu1MAowLGDAbQIHjDFT5GqZpILNmthz4DkiQmOaA0pk7EEadE3MBsxxo70SQt2gL1WFbswxAQIDx4yCA1315vHnvDspZwyTu/LlvFbp3Zs8wW7tlDpVXC5eJILzYDqGrjp6ZfvUGupT5bm9JWPyEvhYIr5+rdnxLsAPoFhrVW3xJwJd/OgFoVoFzLfdTZagxCACEPxF2HgASKvhgVYlJCEBoTRVGgYdzIXgTAtmpdeF1F5RnIoswxijjjDTWaOONOOao44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqqqpREAACH5BAkKAAAALAAAAABAAUABAAT/EMhJq7046827/2AojmRpnmiqrmzrvnAsz3Rt33iu73zv/8CgcEgsGo/IpHLJbDqf0Kh0Sq1ar9isdsvter/gsHhMLpvP6LR6zW673/C4fE6v2+/4vH7P7/v/gIGCg4SFhoeIiYqLjI2Oj5CRkpOUlZaXmJmam5ydnp+goaKjpKWmp6ipqqusra6vsLGys7S1tre4ubq7vL2+v8DBwsPExcbHyMnKy8zNzs/Q0dLT1NXW19jZ2tvc3d7f4OHi4+Tl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/v8AAwocSLCgwYMIEypcyLChw4cQI0qcSLGixYsYM2rcyLGjx48g/0OKHEmypMmTKFOqXMmypcuXMGPKnEmzps2bOHPq3Mmzp8+fxggoGAC0QwEFBSoIIPBzAFMKCqJSKLBggU8EBQoYgCpVAoGqCn5mLZBgQtSwEhRUFfCTQNatabsKAFvUQNanZwEcqLrgadOxCADkNVA16YQDAwYElnlAgICyE+wWYFvhawAJCBIkHnBgZgLHjjvrLUBUQ4DNAy7THAB66eINqBO8ptm4dQfEnHd+FqCag2ieCEoXbYE6sWyYmYsL76B8AGSXmpWDUH78ZfLiw1385rldA+7uNr93iO589szrzj2c3txb5vrE7S8gnoAefEvc5ScotoC7/QHN5rkUXNduE6zX2WYSbBbgTgOWhqBexhUVnWgPAjDhT7g9V2GDP0X3WoUArNdUahSAqNeCOCHQnWbPZXdBZii6KOOMNNZo44045qjjjjz26OOPQAYp5JBEFmnkkUgmqeSSTDbp5JNQRinllFRWaeWVWGap5ZZcdunll2CGKeaYZJZp5plopqnmmmy26eabcMYp55x01mnnnXjmqeeefPbp55+ABirooIQWauihiCaq6KKMNuroo5BGKumklFZq6aWYZqrpppx26umnoIYq6qiklmrqqaimquqqrGYaAQAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YGFBgAtIOBAgYqCCDq80CCCgWiUjCgQIFPBAKWUohaYMKAql19ZhVwYAJXs1UF/Eww1qxUAALAFiWQ9SmAswiqKmA6AcHOA2P9no2rIOkEAQsWEJiJYECCshPoaq1AQEEACZUTL1Ar88CAzwn8AsB6OUOAApoXhJ0Z4PPnAKI3pN57E0EC13Y3IN789zNkDgZ+60QgvOgK17hjt7SN/DOI5qBh3ob+vHlomMybG3dRXGd3DJ4HfKcZfnyF6Y6VM0afe0Nr16VZI48Pnm928TPDp/eqHkB4+k4N0N/acr5R8F5Zrkng2oDDJQiAg+G119N0kDkIAIU/ReiVcxI0xuGEn8VmIQDv/fQaBSP6x2Btxd0m4XYV2LYijDTWaOONOOao44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqrqqqy26qqmEQAAIfkECQoAAAAsAAAAAEABQAEABP8QyEmrvTjrzbv/YCiOZGmeaKqubOu+cCzPdG3feK7vfO//wKBwSCwaj8ikcslsOp/QqHRKrVqv2Kx2y+16v+CweEwum8/otHrNbrvf8Lh8Tq/b7/i8fs/v+/+AgYKDhIWGh4iJiouMjY6PkJGSk5SVlpeYmZqbnJ2en6ChoqOkpaanqKmqq6ytrq+wsbKztLW2t7i5uru8vb6/wMHCw8TFxsfIycrLzM3Oz9DR0tPU1dbX2Nna29zd3t/g4eLj5OXm5+jp6uvs7e7v8PHy8/T19vf4+fr7/P3+/wADChxIsKDBgwgTKlzIsKHDhxAjSpxIsaLFixgzatzIsaPHjyD/Q4ocSbKkyZMoU6pcybKly5cwY8qcSbOmzZs4c+rcybOnz5/GAggIALQDAQEEKhAY8BPBgQoColIwUKCATwQDBhCdEFXAhAFVrfrMOgABV6kSqBZI6vNA1gRnvQIgUNVA0QRZnwLoCgBBWKYUzOrEmtUsXwF1KQhQoABwTKwJ9EoIkNcCWL1gGSuQG9PtW8FYJV8IYECzArs0KZMNIHiD6QKOaSLAS9YoY844PYvWIKD14N1FVSwYTlwBW5ezydb+QLz5Api0lcfm4HyBcZjJpQd3ATxn9wu6d4bnED2B75nZB8DtoDrr1pnttW5wOyH995We1bcua8HzewAH4HUe2HKVTaDaU8uRNeBOhAG2nGfr/UQbZllNMOFPEH5VoQQNSliYhrGp9pN7FCw3wQEL4uRUBXhFuN0Fs6X44ow01mjjjTjmqOOOPPbo449ABinkkEQWaeSRSCap5JJMNunkk1BGKeWUVFZp5ZVYZqnlllx26eWXYIYp5phklmnmmWimqeaabLbp5ptwxinnnHTWaeedeOap55589unnn4AGKuighBZq6KGIJqrooow26uijkEYq6aSUVmrppZhmqummnHbq6aeghirqqKSWauqpqKaq6qqstqppBAAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YOEDgAtMMAAgQqJCDqEwHTCUiTQhUgoOmAAQEoRJ1wgGpVn1cHIICKdILXBD8PXEUrYSuABF6LJrjKdCsCr08ljNWJIOzYrQOoSm1boMCAmX2XUghA10IAAXsHGChcYDBMtWv39s1r4cBkygZqMg4bYO8GygUMsK2JYG7YDgQKW76JmXMGyD2dFn2hoLfvyjBbh339wbdxBTBdDz9c/Ljh4MqJ72YhwDZO6xcELFjwNWftDtu3K5gtU/jaDgEKhF9QQPTwrBrUQlUQvvvlsAlMi+18Fb4E7QswF1PWXwPkNRpRxPlVFIHMEYfZaj65xpR0EqZ1ngTSMfiTa/pdtZiHYGFFgXQSHGAaT7pRMBeE01nQ2oktxijjjDTWaOONOOao44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqrqqpxGAAAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YQJEAAtEOCAQkqBDjwEwFTCgOiQiVAwCeCqAGgSpVwgOqAn1EHEJUQdsIAqll9HoialOzWAFSrAj064GlZBHGfThib82pUomXhEvg6IYEAAXphXk2QOEDUxFzFcj18uG3MtWzHXoVcAS9lAXJnOg4bgK+Gz4hvCg1LeEOAyjsxc8YgmafToi8K6N5toHXL1ax9c9hNvABMusFBFC/QWzHysrhbCDCtc/YFAgoUCIj9uEP27AWEywSOtMMBA98VGKg5GusGAQvSDijwfbtMzEj51qZgYMEC4xMIQJ/geL91N8FoTN3l3wKhWQUddPAtoEBRdNm1FQAK+GdfT5hZBh0AAyz4E136XQhAAf5Rl5N7ZpkIAGhNQXaUZdFdIJSKNeao44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqrqqqy26uqrsMYq66yiRgAAIfkECQoAAAAsAAAAAEABQAEABP8QyEmrvTjrzbv/YCiOZGmeaKqubOu+cCzPdG3feK7vfO//wKBwSCwaj8ikcslsOp/QqHRKrVqv2Kx2y+16v+CweEwum8/otHrNbrvf8Lh8Tq/b7/i8fs/v+/+AgYKDhIWGh4iJiouMjY6PkJGSk5SVlpeYmZqbnJ2en6ChoqOkpaanqKmqq6ytrq+wsbKztLW2t7i5uru8vb6/wMHCw8TFxsfIycrLzM3Oz9DR0tPU1dbX2Nna29zd3t/g4eLj5OXm5+jp6uvs7e7v8PHy8/T19vf4+fr7/P3+/wADChxIsKDBgwgTKlzIsKHDhxAjSpxIsaLFixgzatzIsaPHjyD/Q4ocSbKkyZMoU6pcybKly5cwY8qcSbOmzZs4c+rcybOnz5/GECRAALRDggEJKhwg6hPBgQoDolIIILUngqgBKEQdMOEq0p9bmQLYOuHogKc+D0RNKoEsALVfgZpFS9brALES8N60S5Qs3KwT4Op1eTUBWglUz1q4ylTo1sMw4SJtrDgDgsRYa2IeEGDwha2T95qtugEu5JumPSy1erqoCgGwYxMATHi0Ww+xcwuAaft2B90CZsN0DJqr6xYCPKP2MKBAAQI7U3Nw7tyA8ZrE45Y2QL2AAc2gaWMgoADwAO7OocuUPHTCXQsCFCj4PoGA8+vDo0JO/HSBfwAIyKcA235WueXfAhLEp0ABRc0lwYETFCDfbmmtNQGEbQn4k1liYSiBAfIpZ1NmF/5HgQAE6uRUBQosoMBxGhCwgHow1mjjjTjmqOOOPPbo449ABinkkEQWaeSRSCap5JJMNunkk1BGKeWUVFZp5ZVYZqnlllx26eWXYIYp5phklmnmmWimqeaabLbp5ptwxinnnHTWaeedeOap55589unnn4AGKuighBZq6KGIJqrooow26uijkEYq6aSUVmrppZhmqummnHbq6aeghirqqKSWauqpqKaq6qqsturqq6JGAAAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YQJEAAtEOCAQkqHCDqE8GBCgOiUgggtSeCqAEoRB0w4SrSn1uZAtg64eiApz4PRE0qgSwAtV+BmkVL1usAsRLw3rRLlCzcrBPg6nV5NQFaCVTPWrjKVOjWwzDhIm2sOAOCxFhrYh4QYPCFrZP3mq26AS7km6Y9LLV6uqgK0Gs9p3QMGwTstTBHg7YNeyhM2rtdt7ib1kMAAQLY5kzNAbnz1jGBK9eAgIBzAQQ0gwacYUABtAeuT38p2TeAAAsEWBBQoIABCgmQQ2fpFXKBBQveK9gPAEH7AlwBRQDhfgsQtZ8CEhDQ3ntAKYCfegAcOIEB7WXnkwD4ISiBhG3995ODC1gYIX8TtiebTfgVQAGHExAQYE/WVVCAAioK150CItqo44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqrqqqy26uqrsMYq66y0mhoBACH5BAkKAAAALAAAAABAAUABAAT/EMhJq7046827/2AojmRpnmiqrmzrvnAsz3Rt33iu73zv/8CgcEgsGo/IpHLJbDqf0Kh0Sq1ar9isdsvter/gsHhMLpvP6LR6zW673/C4fE6v2+/4vH7P7/v/gIGCg4SFhoeIiYqLjI2Oj5CRkpOUlZaXmJmam5ydnp+goaKjpKWmp6ipqqusra6vsLGys7S1tre4ubq7vL2+v8DBwsPExcbHyMnKy8zNzs/Q0dLT1NXW19jZ2tvc3d7f4OHi4+Tl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/v8AAwocSLCgwYMIEypcyLChw4cQI0qcSLGixYsYM2rcyLGjx48g/0OKHEmypMmTKFOqXMmypcuXMGPKnEmzps2bOHPq3Mmzp8+fxhAkQAC0Q4IBCSocIOoTwYEKA6JSCCC1J4KoAShEHTDhKtKfW5kC2Drh6ICnPg9ETSqBLAC1X4GaRUvW6wCxEvDetEuULNysE+DqdXk1AVoJVM9auMpU6NbDMOEibaw4A4LEWGtiHhBg8IWtk/earboBLuSbpj0stXq6qArQaz2ndAwbBOy1MEeDtg17KEzau123WM3zgAHVUVvXFLBggQCjW33bHKCgefMOl0EDnlnA+oIC2y8EENB4tHKWzJsrICDhwHoLAwQIYB/4qOyVBJo/n2BAgYLnBQQIAOUC8glw3kx6UecfUQEWIEECBRZVgH/7NTgBAfKx1ZMA/jkogYXtRejThApw9aGAF8p3X03+HTcBiGUdON1+/BXgonAYDFAAfTj26OOPQAYp5JBEFmnkkUgmqeSSTDbp5JNQRinllFRWaeWVWGap5ZZcdunll2CGKeaYZJZp5plopqnmmmy26eabcMYp55x01mnnnXjmqeeefPbp55+ABirooIQWauihiCaq6KKMNuroo5BGKumklFZq6aWYZqrpppx26umnoIYq6qiklmrqqaimquqqrLbq6quwxirrrLTWauutqkYAACH5BAkKAAAALAAAAABAAUABAAT/EMhJq7046827/2AojmRpnmiqrmzrvnAsz3Rt33iu73zv/8CgcEgsGo/IpHLJbDqf0Kh0Sq1ar9isdsvter/gsHhMLpvP6LR6zW673/C4fE6v2+/4vH7P7/v/gIGCg4SFhoeIiYqLjI2Oj5CRkpOUlZaXmJmam5ydnp+goaKjpKWmp6ipqqusra6vsLGys7S1tre4ubq7vL2+v8DBwsPExcbHyMnKy8zNzs/Q0dLT1NXW19jZ2tvc3d7f4OHi4+Tl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/v8AAwocSLCgwYMIEypcyLChw4cQI0qcSLGixYsYM2rcyLGjx48g/0OKHEmypMmTKFOqXMmypcuXMGPKnEmzps2bOHPq3Mmzp8+fxhAkQAC0Q4IBCSocIOoTwYEKA6JSCCC1J4KoAShEHTDhKtKfW5kC2Drh6ICnPg9ETSqBLAC1X4GaRUvW6wCxEvDetEuULNysE+DqdXk1AVoJVM9auMpU6NbDMOEibaw4A4LEWGtiHhBg8IWtk/earboBLuSbpj0stXq6qArQaz2nJKBgge3bIGCvhXm794LcsIfCpO37t+sWq3kiEKA6auuaAhQoIGB0q3CbAwpIl97hMmjAMw1sV2AA/AW1jUc/ZxldegGub99b+EvhwFHZKwdIZz7BQIECzAkgIOAAfO2kV3b/ESUgf3Cx9ZN/BVAHwIJlOfcTAf8ZMAGFebnV03/yScAhYlHhV1OGFIwoQXI9DSDhBAQI8OJxFwQggHk05qjjjjz26OOPQAYp5JBEFmnkkUgmqeSSTDbp5JNQRinllFRWaeWVWGap5ZZcdunll2CGKeaYZJZp5plopqnmmmy26eabcMYp55x01mnnnXjmqeeefPbp55+ABirooIQWauihiCaq6KKMNuroo5BGKumklFZq6aWYZqrpppx26umnoIYq6qiklmrqqaimquqqrLbq6quwxirrrKRGAAAh+QQJCgAAACwAAAAAQAFAAQAE/xDISau9OOvNu/9gKI5kaZ5oqq5s675wLM90bd94ru987//AoHBILBqPyKRyyWw6n9CodEqtWq/YrHbL7Xq/4LB4TC6bz+i0es1uu9/wuHxOr9vv+Lx+z+/7/4CBgoOEhYaHiImKi4yNjo+QkZKTlJWWl5iZmpucnZ6foKGio6SlpqeoqaqrrK2ur7CxsrO0tba3uLm6u7y9vr/AwcLDxMXGx8jJysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAMKHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIP9DihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn8YQJEAAtEOCAQkqHCDqE8GBCgOiUgggtSeCqAEoRB0w4SrSn1uZAtg64eiApz4PRE0qgSwAtV+BmkVL1usAsRLw3rRLlCzcrBPg6nU5YMECAVOjoqVwlanQrYthCjC8QAGBvGc1IKC6FfDMApQXFPCsYSvSwTEJKAjdAW7km5MPe1ja8wDioi5Mr0WdUnVowyB0r4X5m3Jw3UNh+v6N2wVtnghuc3C9k0CBApc5mD19M4GB69c7bDZNOuZ38AZeK72bd7v6ltavG+AKIHr5t1gpHDjKe+WA69lJQIDbAAJwVVdYO+llG4F9VQUXWz8RKABbbgEw108JSDhBhXZFSOBiFQLAWX81EUhfW1UFRmJNalVwFITNXSDUijHWaOONOOao44489ujjj0AGKeSQRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmqeWWXHbp5ZdghinmmGSWaeaZaKap5ppstunmm3DGKeecdNZp55145qnnnnz26eefgAYq6KCEFmrooYgmquiijDbq6KOQRirppJRWaumlmGaq6aacdurpp6CGKuqopJZq6qmopqrqqqy26uqrmUYAACH5BAkKAAAALAAAAABAAUABAAT/EMhJq7046827/2AojmRpnmiqrmzrvnAsz3Rt33iu73zv/8CgcEgsGo/IpHLJbDqf0Kh0Sq1ar9isdsvter/gsHhMLpvP6LR6zW673/C4fE6v2+/4vH7P7/v/gIGCg4SFhoeIiYqLjI2Oj5CRkpOUlZaXmJmam5ydnp+goaKjpKWmp6ipqqusra6vsLGys7S1tre4ubq7vL2+v8DBwsPExcbHyMnKy8zNzs/Q0dLT1NXW19jZ2tvc3d7f4OHi4+Tl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/v8AAwocSLCgwYMIEypcyLChw4cQI0qcSLGixYsYM2rcyLGjx48g/0OKHEmypMmTKFOqXMmypcuXMGPKnEmzps2bOHPq3Mmzp8+fxhAkQAC0Q4IBCSocIOqTgIAKA6JSCCC1J4IFCwpQiDpgAoKoSX1iXdBVAtcJRwcc+CkAq4IJZwEcAFtUAdanAM5+jcrU604CY9eenTsgAAXCfWEOUFAAr4QCWA1Y+MpUKNe1MgUo2FygbIAFji8goMrVME0DmzcbwLyBK9LEMwcUSP2WA2HWODUrIOBhqdXQRVe4Bgt75QADBZIrBzGc7kvl0LV+aD5UMfLowV345vm1d1TcNxMIEGB6Q9rXNw+MX99htOvyMp2uJ1D88IDK58G7FD+egGnKFhAG3+ABR9XHknoChCUBaYJJtdd9O8H2IFFxEaagT2lhFhcAGf5kIVxVAfDgT2n1tSEApBloU1TwnSiXijYhAN5RF2Y3WXU25qjjjjz26OOPQAYp5JBEFmnkkUgmqeSSTDbp5JNQRinllFRWaeWVWGap5ZZcdunll2CGKeaYZJZp5plopqnmmmy26eabcMYp55x01mnnnXjmqeeefPbp55+ABirooIQWauihiCaq6KKMNuroo5BGKumklFZq6aWYZqrpppx26umnoIYq6qiklmrqqaimquqqrLbq6quwxirrrKdGAAA7";
}

// 25. ajax 통신시 사용 1
$(document).ready(function() {
	var ssuniq_sheet = document.createElement('style');
	ssuniq_sheet.innerHTML += ".ssuniqwrap-loading{";
	ssuniq_sheet.innerHTML += "    position: fixed;";
	ssuniq_sheet.innerHTML += "    left:0;";
	ssuniq_sheet.innerHTML += "    right:0;";
	ssuniq_sheet.innerHTML += "    top:0;";
	ssuniq_sheet.innerHTML += "    bottom:0;";
	ssuniq_sheet.innerHTML += "    background: rgba(0,0,0,0.2);";
	ssuniq_sheet.innerHTML += "    filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000', endColorstr='#20000000');";
	ssuniq_sheet.innerHTML += "}";
	ssuniq_sheet.innerHTML += "";
	ssuniq_sheet.innerHTML += ".ssuniqwrap-loading div{";
	ssuniq_sheet.innerHTML += "     position: fixed;";
	ssuniq_sheet.innerHTML += "     top:50%;";
	ssuniq_sheet.innerHTML += "     left:50%;";
	ssuniq_sheet.innerHTML += "     margin-left: -21px;";
	ssuniq_sheet.innerHTML += "     margin-top: -21px;";
	ssuniq_sheet.innerHTML += "}";
	ssuniq_sheet.innerHTML += "";
	ssuniq_sheet.innerHTML += ".ssuniqdisplay-none{";
	ssuniq_sheet.innerHTML += "    display:none;";
	ssuniq_sheet.innerHTML += "}";
	document.body.appendChild(ssuniq_sheet);
});

/**
 * ajax 요청
 * 
 * @param isAsynch
 * @param isShowLoadingBar
 * @param address
 * @param data
 * @param callBack
 * @returns
 */
function ajaxCallBack(isMultipart, address, reqType, dataObj, callBack, resDataType, isAsynch, isShowLoadingBar) {  // 33. ajaxCallBack 이름의 의미는 어떤 이벤트가 발생하고 실행될(callBack) ajax 라는 뜻.
	var contentType;
	var enctype;
	var data;
	
	/*
	  	자바스크립트는 초과된 매개 변수는 그냥 무시한 채 진행됩니다. 또 원래 지정된 매개 변수보다 적게 입력했을 경우에는 undefined가 입력됩니다. 
	  	그리고 함수에 따라서는 매개 변수의 개수에 따라서 다른 기능을 하도록 구현되어 있기도 하는데, 예를 들어 Array() 함수는 인자가 없을 때, 하나일때, 두 개 이상일 때 그 기능이 모두 다릅니다.(가변인자 함수) 
	 */
	if (typeof isAsynch == "undefined" || isAsynch == null) { 
		isAsynch 			= true;
	}
	if (typeof isShowLoadingBar == "undefined" || isShowLoadingBar == null) {
		isShowLoadingBar 	= false;
	}
	if (isMultipart) {
		contentType 		= false;
		enctype 			= 'multipart/form-data';
		data 				= dataObj
	} else {
		contentType 		= "application/json; charset=UTF-8";
		enctype 			= false;
		data 				= (pageContext.string.equalsIgnoreCase(reqType, "GET"))? (dataObj == null)? {} : dataObj      :      (dataObj == null)? JSON.stringify({}) : JSON.stringify(dataObj);
	}
	
	$.ajax({
       type 		: reqType,  // 1. type(default: 'GET')속성은 Type: String이고 get, post 중 전송방식을 선택한다.
       url 			: address,  // 2. url(default: The current page)속성은 Type: String이고 요청할 url 주소, 컨트롤러에 mapping되어진 url 주소를 적어준다.
       dataType 	: resDataType,  // 3. dataType(default: Intelligent Guess (xml, json, script, or html))속성은 Type: String이고 서버에서 받을 데이터 형식을 지정한다. 만약 지정하지 않으면 MIME 타입을 참고하여 자동 파싱된다.
       data 		: data,  // 4. data 속성은 Type: PlainObject or String or Array이고 서버로 보낼 데이터를 지칭한다.
       contentType 	: contentType, // 5. contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8') Type: Boolean or String 해더의 Content-Type을 설정한다.
       enctype 		: enctype,   // 6. HTML의 FORM 태그를 이용해 파일업로드를 사용할 경우 form의 속성으로 enctype="multipart/form-data"를 추가해 사용한다. 하지만 경우에 따라 이를 조정해야 하는 경우가 생기는데 ajax에 이것을 조정해주는 속성이 존재하는데 enctype 속성이다."multipart/form-data" or false;						 		
       async		: isAsynch,  // 7. async 속성은 (default: true) Type : Boolean이고 기본적으로 비동기 요청을 하도록 하는 값이다. 동기 요청이 필요하면 값을 false로 설정하면 된다.
       processData 	: false,  // 8. processData(default: true) 속성은 Type: Boolean이고  데이터를 querystring 형태로 보내지 않고 DOMDocument 또는 다른 형태로 보내고 싶으면 false로 설정한다.
       cache 		: false,  // 9. cache(default: true, false for dataType 'script' and 'jsonp') 속성에서 Type: Boolean false로 설정 시 브라우저에서 강제로 캐시되지 않도록 한다. false로 설정 시 HEAD 및 GET 요청 시 정상동작한다.
       success 		: function(response) {  // 10. success 속성은  안에 function이 같이 있는데 통신에 성공했을 때 실행된다.
    	   //console.log("response:" + response);
    	   if (resDataType == "html") {  // 11. 만약 dataType이 html일 경우
    		   callBack(response);// 12. 응답 dataType response 데이터를 callBack 함수에 실어서 던져준다. 여기서 callBack 함수란 어떤 이벤트가 발생한 후, 수행될 함수를 의마한다.
    	   } else {  // 13. html이 아닌 모든 경우에는 
               var status 		= response.status;  // 14. response.status의 값을 status 변수에 저장.
               if (pageContext.string.equalsIgnoreCase(status, "success")) { // 15. 상태값에 success가 있으면 html이 아니더라도
             	  callBack(response); // 16. 응답 dataType response 데이터를 callBack 함수에 실어서 던져준다.
               } else {  // 17. 그 외에
            	   if (!(typeof response.type == "undefined" || response.type == null) && response.type.indexOf("text/html") != -1) {  // 18. response.type에 undefined 이거나 null 동시에 text/html이라는 문자가 없다면 
            		   $('body').append(response.message);  // 19. body태그에 message를 추가해주고
                   } else {  // 20. 그렇지않으면
                	   alert(response.message); // 21. alert로 메시지를 띄워준다.  
                   }
               }
    	   }
       },
       beforeSend 	:function() {  // 22. beforeSend Type: Function(  jqXHR jqXHR, PlainObject settings )속성은 전송 전에 실행되며 false 를 리턴하게 되면 요청이 취소된다.
    	   if (isShowLoadingBar) {  // 23. isShowLoadingBar 값이 true일때
    		   $('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");  // 24. body 태그에 로딩 이미지를 띄워준다.
    	   }
       },
       complete 	:function() {  // 27. comptete(Function)은 요청이 완료되면 호출되는 함수이다. 함수의 매개변수 두 개가 전달되는데 각각 XHR 인스턴스와 success 혹은 error 를 나타내는 상태 메시지 문자열이다. success나 error 롤백을 명시했다면 이 함수는 해당 콜백이 호출된 후에 실행된다.
    	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();  // 28. success속성과 error 속성을 명시해줬기 때문에 callback 호출 후 이 부분이 실행된다.(#ssuniqwrap-loading을 지우는 작업)
       },
       error 		:function(request, status, error) {  // 29. ajax 통신에 실패 했다면 
    	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();  // 30. #ssuniqwrap-loading를 지우고
    	   console.log(JSON.stringify(request) + "/" + status + "/" + error);  // 31. 콘솔에 request에 담긴 json 메시지를 string으로 바ㅜ꺼서 status값과 error 값을 /로 구분하여 로그를 찍어준다.
           alert("서버와의 통신이 올바르지 않습니다. 다시 시도하세요");  // 32. 그리고 alert메시지를 나타낸다.
       }
    });
}

/**
 * 서버에 json 요청
 * 
 * @param address
 * @param data
 * @param callBack
 * @param isAsynch
 * @param isShowLoadingBar
 * @returns
 */
function ajaxCallBackJsonGet(address, data, callBack, isAsynch, isShowLoadingBar) { //ajaxCallBack(address, "GET", data, callBack, "json", isAsynch, isShowLoadingBar);
	
	// 1. get 방식은 프로토콜 body가 없으니 json을 query형태의 parameter로 전송하고 서버측에서 query를 json으로 변환하여 사용한다
	if (isShowLoadingBar) {  // 2. isShowLoadingBar가 true이면
		$('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");  // 3. body에 로딩바와 이미지 나타낸다.
	}
	
	$.get(address, data).done(function(response) {  // 4. 매개변수로 전달된 주소 값과 data 값을 가지고 response에 data를 담아서
		callBack(response);  // 5. callBack 함수에게 응답 객체 response를 던져준다.
	})
	.fail(  // 5. 통신에 실패하면
			function() {
				if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();  // 6. 로딩바를 제거해주고
				alert("서버와의 통신이 올바르지 않습니다. 다시 시도하세요");  // 7. alert창을 띄워준다.
			}
	)
	.always(  // 7. 실패한 경우가 아닌 모든 경우에는
			function() {
				if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();  // 8.  로딩바만 제거해준다.
			}
	);
}

function ajaxCallBackJsonPost(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "POST", data, callBack, "json", isAsynch, isShowLoadingBar);
}

function ajaxCallBackJsonPut(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "PUT", data, callBack, "json", isAsynch, isShowLoadingBar);
}

function ajaxCallBackJsonDelete(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "DELETE", data, callBack, "json", isAsynch, isShowLoadingBar);
}





